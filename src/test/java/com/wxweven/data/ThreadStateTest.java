package com.wxweven.data;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author wxweven
 * @date 2018/12/24
 */
public class ThreadStateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadStateTest.class);

    @Test
    public void test() {
        Thread thread = new Thread(() -> {
            LOGGER.info("线程开始执行了...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("线程结束执行了...");
        });

        LOGGER.info("线程状态={}", thread.getState());

        thread.start();

        LOGGER.info("线程状态={}", thread.getState());

    }

    @Test
    public void testInBlockedIOState() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // 创建一个名为“输入输出”的线程t
        Thread t = new Thread(() -> {
            try {
                // 命令行中的阻塞读
                String input = in.nextLine();
                System.out.println(input);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(in);
            }
        }, "输入输出"); // 线程的名字

        // 启动
        t.start();

        // 确保run已经得到执行
        Thread.sleep(100);

        LOGGER.info("线程状态={}", t.getState());


        // 状态为RUNNABLE
        Assert.assertTrue(t.getState().equals(Thread.State.RUNNABLE));
    }

    @Test
    public void testBlocked() throws Exception {
        class Counter {
            private int counter;

            public synchronized void increase() {
                counter++;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Counter c = new Counter();

        Thread t1 = new Thread(c::increase, "t1线程");
        t1.start();

        Thread t2 = new Thread(c::increase, "t2线程");
        t2.start();

        Thread.sleep(100); // 确保 t2 run已经得到执行

        LOGGER.info("线程状态={}", t2.getState());

        // 状态为 BLOCKED
        Assert.assertTrue(t2.getState().equals(Thread.State.BLOCKED));
    }

    @Test
    public void testReenterBlocked() throws Exception {
        class Account {
            int amount = 100; // 账户初始100元

            public synchronized void deposit(int cash) { // 存钱
                amount += cash;
                notify();
                try {
                    Thread.sleep(30000); // 通知后却暂时不退出
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            public synchronized void withdraw(int cash) { // 取钱
                while (cash > amount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                amount -= cash;
            }
        }
        Account account = new Account();

        Thread withdrawThread = new Thread(() -> account.withdraw(200), "取钱线程");
        withdrawThread.start();

        Thread.sleep(100); // 确保取钱线程已经得到执行

        Assert.assertTrue(withdrawThread.getState().equals(Thread.State.WAITING));


        Thread depositThread = new Thread(() -> account.deposit(100), "存钱线程");
        Thread.sleep(10000); // 让取钱线程等待一段时间
        depositThread.start();

        Thread.sleep(300); // 确保取钱线程已经被存钱线程所通知到


        LOGGER.info("线程状态={}", withdrawThread.getState());

        Assert.assertTrue(withdrawThread.getState().equals(Thread.State.BLOCKED));
    }

    @Test
    public void testBlockedState() throws Exception {
        class Toilet { // 厕所类
            public void pee() {
                try {
                    Thread.sleep(21000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        Toilet toilet = new Toilet();

        Thread passenger1 = new Thread(() -> {
            synchronized (toilet) {
                toilet.pee();
            }
        });

        Thread passenger2 = new Thread(() -> {
            synchronized (toilet) {
                toilet.pee();
            }
        });

        passenger1.start();

        // 确保乘客1先启动
        Thread.sleep(100);

        passenger2.start();

        // 确保已经执行了 run 方法
        Thread.sleep(100);

        // 在乘客1在厕所期间，乘客2处于 BLOCKED 状态
        LOGGER.info("线程状态={}", passenger2.getState());
        Assert.assertTrue(passenger2.getState().equals(Thread.State.BLOCKED));
    }

    @Test
    public void testWaitingState() throws Exception {

        class Toilet { // 厕所类
            int paperCount = 0; // 纸张

            public void pee() { // 上厕所方法
                try {
                    Thread.sleep(21000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        Toilet toilet = new Toilet();

        // 两乘客线程
        Thread[] passengers = new Thread[2];
        for (int i = 0; i < passengers.length; i++) {
            passengers[i] = new Thread(() -> {
                synchronized (toilet) {
                    while (toilet.paperCount < 1) {
                        try {
                            toilet.wait(); // 条件不满足，等待
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    toilet.paperCount--; // 使用一张纸
                    toilet.pee();
                }
            });
        }

        // 乘务员线程
        Thread steward = new Thread(() -> {
            synchronized (toilet) {
                toilet.paperCount += 10;// 增加十张纸
                toilet.notifyAll();// 通知所有在此对象上等待的线程
            }
        });

        passengers[0].start();
        passengers[1].start();

        // 确保已经执行了 run 方法
        Thread.sleep(100);

        // 没有纸，两线程均进入等待状态

        LOGGER.info("passengers[0]线程状态={}", passengers[0].getState());
        LOGGER.info("passengers[1]线程状态={}", passengers[1].getState());
        Assert.assertTrue(passengers[0].getState().equals(Thread.State.WAITING));
        Assert.assertTrue(passengers[1].getState().equals(Thread.State.WAITING));


        // 乘务员线程启动，救星来了
        steward.start();

        // 确保已经增加纸张并已通知
        Thread.sleep(100);

        // 其中之一会得到锁，并执行 pee，但无法确定是哪个，所以用 "或 ||"
        // 注：因为 pee 方法中实际调用是 sleep， 所以很快就从 RUNNABLE 转入 TIMED_WAITING(sleep 时对应的状态)
        Assert.assertTrue(Thread.State.TIMED_WAITING.equals(passengers[0].getState())
                || Thread.State.TIMED_WAITING.equals(passengers[1].getState()));

        // 其中之一则被阻塞，但无法确定是哪个，所以用 "或 ||"
        Assert.assertTrue(
                Thread.State.BLOCKED.equals(passengers[0].getState()) || Thread.State.BLOCKED.equals(passengers[1].getState()));
    }

    @Test
    public void testTimedWaitingState() throws Exception {

        class Toilet { // 厕所类
            int paperCount = 0; // 纸张

            public void poo() {
                try {
                    Thread.sleep(21000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        Toilet toilet = new Toilet();

        // 一直等待的线程1
        Thread passenger1 = new Thread(() -> {
            synchronized (toilet) {
                while (toilet.paperCount < 1) {
                    try {
                        // 条件不满足，等待
                        toilet.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                // 使用一张纸
                toilet.paperCount--;
                toilet.poo();
            }
        });

        // 只等待1000毫秒的线程2
        Thread passenger2 = new Thread(() -> {
            synchronized (toilet) {
                while (toilet.paperCount < 1) {
                    try {
                        toilet.wait(1000); // 条件不满足，但只等待1000毫秒
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                toilet.paperCount--; // 使用一张纸
                toilet.poo();
            }
        });

        // 乘务员线程
        Thread steward = new Thread(() -> {
            synchronized (toilet) {
                toilet.paperCount += 10;// 增加十张纸
                // 粗心的乘务员线程，没有通知到，（这里简单把代码注释掉来模拟）
                // toilet.notifyAll();// 通知所有在此对象上等待的线程
            }
        });

        passenger1.start();
        passenger2.start();

        // 确保已经执行了 run 方法
        Thread.sleep(100);

        // 没有纸，两线程均进入等待状态，其中，线程2进入 TIMED_WAITING
        LOGGER.info("passengers[0]线程状态={}", passenger1.getState());
        LOGGER.info("passengers[1]线程状态={}", passenger2.getState());
        Assert.assertTrue(passenger1.getState().equals(Thread.State.WAITING));
        Assert.assertTrue(passenger2.getState().equals(Thread.State.TIMED_WAITING));

        // 此时的纸张数应为0
        Assert.assertTrue(toilet.paperCount == 0);

        // 乘务员线程启动
        steward.start();

        // 确保已经增加纸张
        Thread.sleep(100);

        // 此时的纸张数应为10
        Assert.assertTrue(toilet.paperCount == 10);

        // 确保线程2已经自我唤醒
        Thread.sleep(1000);

        // 如果纸张已经被消耗一张，说明线程2已经成功自我唤醒
        Assert.assertTrue(toilet.paperCount == 9);
    }
}

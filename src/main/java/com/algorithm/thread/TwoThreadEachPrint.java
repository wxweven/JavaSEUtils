package com.algorithm.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadEachPrint {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        TwoThreadEachPrint main = new TwoThreadEachPrint();

        new Thread(main.new ThreadC(Arrays.asList(1, 2, 3, 4, 5))).start();
        new Thread(main.new ThreadC(Arrays.asList("A", "B", "C", "D", "E"))).start();

    }

    class ThreadC implements Runnable {
        private List<Object> list;
        private int i = 0;

        public ThreadC(List<Object> list) {
            this.list = list;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (Object o : list) {
                    // 1. 打印当前元素
                    System.out.println(o);

                    // 2. 打印完成后，先唤醒其他阻塞的线程
                    // 这里一定是先唤醒其他线程，然后再阻塞自己，
                    // 如果先阻塞自己，再唤醒all，有可能把自己也唤醒
                    condition.signalAll();

                    // 3. 然后再阻塞自己
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 4. 最后再释放锁
                lock.unlock();
            }
        }
    }
}

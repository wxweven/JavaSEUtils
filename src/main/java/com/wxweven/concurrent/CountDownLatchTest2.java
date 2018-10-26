package com.wxweven.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * 下面的这个例子可以理解为 F1 赛车的维修过程， 只有 startSignal命令下达之后，维修工才开始干活，
 * 只有等所有工人（doneSignal）完成工作之后，赛车才能继续
 * <p>
 * <p>
 * CountDownLatch 适用于一组线程和另一个主线程之间的工作协作。
 * 一个主线程等待一组工作线程的任务完毕才继续它的执行是使用CountDownLatch 的主要场景
 *
 * @author wxweven
 * @version 1.0
 * @date 2016年8月28日
 * @email wxweven@qq.com
 * @blog wxweven.win
 * @Copyright: Copyright (c) wxweven 2009 - 2016
 */
public class CountDownLatchTest2 {
    private static final int WORKER_SIZE = 5;
    private static final int COMMANDER_SIZE = 1;

    private CountDownLatch startSignal = new CountDownLatch(COMMANDER_SIZE);
    private CountDownLatch fixedSignal = new CountDownLatch(COMMANDER_SIZE);

    @Test
    public void testCountDownLatch() throws InterruptedException {
        System.out.println("正在执行准备工作...");

        IntStream.range(0, WORKER_SIZE)
                 .forEach(i -> new Thread(() -> {
                     try {
                         System.out.println("工人" + i + " 准备好了！");
                         startSignal.await();
                         beginFix();
                         fixedSignal.countDown();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }).start());

        Thread.sleep(500);
        System.out.println("工人开始修车吧...");
        startSignal.countDown();
        fixedSignal.await();
        System.out.println("工人修车修好了...");
    }

    private void beginFix() throws InterruptedException {
        System.out.println("工作线程 " + Thread.currentThread().getName() + " 在工作...");
        Thread.sleep(500);
        System.out.println("工作线程 " + Thread.currentThread().getName() + " 工作结束了...");
    }

}

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

        new Thread(main.new ThreadA(Arrays.asList(1, 2, 3, 4, 5))).start();
        Thread.sleep(100);
        new Thread(main.new ThreadA(Arrays.asList("A", "B", "C", "D", "E"))).start();
    }

    class ThreadA implements Runnable {
        List<Object> list;
        int i = 0;

        public ThreadA(List<Object> list) {
            this.list = list;
        }

        public void run() {
            lock.lock();
            try {
                while (i < list.size()) {
                    System.out.println(list.get(i++));
                    condition.signalAll();
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

package com.wxweven.concurrent;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Exchanger;

/**
 * Created by wxweven
 * on 17/7/26.
 */
public class ExchangerTest {

    private static class ThreadA extends Thread {
        private Exchanger<String> exchanger;

        public ThreadA(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程A开始执行...");
                System.out.println("在线程A中得到线程B的值：" + exchanger.exchange("from A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadB extends Thread {
        private Exchanger<String> exchanger;

        public ThreadB(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程B开始执行...");
                System.out.println("在线程B中得到线程A的值：" + exchanger.exchange("from B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Exchanger<String> exchanger2 = new Exchanger<>();

        ThreadA threadA = new ThreadA(exchanger);
        ThreadB threadB = new ThreadB(exchanger2);

        threadA.start();
        threadB.start();

    }
}

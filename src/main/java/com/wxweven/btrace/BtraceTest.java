package com.wxweven.btrace;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wxweven
 * @date 2018/8/16
 */
public class BtraceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread.sleep(30000);
//        BtraceTest.sayHello("aaa", 5);
        Future<Integer> integerFuture = BtraceTest.get(10);
        System.out.println(integerFuture.get());
    }

    public static String sayHello(String name, int age) {
        System.out.println("----------");
        return "hello everyone";
    }

    public static Future<Integer> get(int i) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> i + 1);
        executorService.shutdown();
        return future;
    }
}

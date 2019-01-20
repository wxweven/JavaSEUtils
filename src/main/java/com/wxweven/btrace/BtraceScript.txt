package com.wxweven.btrace;

import com.sun.btrace.annotations.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.sun.btrace.BTraceUtils.println;

@BTrace(unsafe = true)
public class BtraceScript {
    @OnMethod(
            clazz = "com.wxweven.btrace.BtraceTest",
            method = "get",
            location = @Location(Kind.RETURN)//函数返回的时候执行，如果不填，则在函数开始的时候执行
    )
    public static void get(int age, @Return Future<Integer> future) throws ExecutionException, InterruptedException {
        println("age: " + age);
        println("result:" + future.get());
    }
}
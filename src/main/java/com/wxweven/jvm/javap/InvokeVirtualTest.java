package com.wxweven.jvm.javap;

public class InvokeVirtualTest {
    public static void main(String[] args) {
        Father test = new Son();
        test.say();
    }
}
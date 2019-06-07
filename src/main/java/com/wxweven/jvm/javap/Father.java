package com.wxweven.jvm.javap;

public class Father {

    public void say() {
        System.out.println("i am fater");
        System.out.println(this);
        this.hello();
        this.hi();
    }

    private void hello() {
        System.out.println("father say hello");
    }

    public void hi() {
        System.out.println("father say hi");
    }
}
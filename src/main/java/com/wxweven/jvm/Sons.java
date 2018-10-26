package com.wxweven.jvm;

/**
 * Created by wxweven on 2018/3/14.
 */
public class Sons extends Fathers {

    public static void staticMethod() {
        System.out.println("static::sons");
    }

    @Override
    public void method() {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Sons sons = new Sons();
        sons.staticMethod();

        Fathers fathers = new Sons();
        fathers.staticMethod();

        fathers.method();
    }
}

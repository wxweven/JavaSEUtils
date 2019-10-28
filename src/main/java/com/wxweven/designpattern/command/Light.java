package com.wxweven.designpattern.command;

/**
 * 命令模式中的receiver，最终负责执行具体的操作
 *
 * @author wxweven
 */
public class Light {
    public void on() {
        System.out.println("turn on the light");
    }
}
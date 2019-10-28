package com.wxweven.designpattern.command;

/**
 * 命令模式中的concrete command，持有receiver的引用，将操作委托给receiver
 *
 * @author wxweven
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }
}
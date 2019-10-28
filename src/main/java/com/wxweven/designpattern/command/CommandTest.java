package com.wxweven.designpattern.command;

import org.junit.Test;

/**
 * @author wxweven
 */
public class CommandTest {
    @Test
    public void test() {
        /*
         * 命令模式中的client，负责创建具体的command并将之与receiver绑定
         */

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.onButtonPressed();
    }
}
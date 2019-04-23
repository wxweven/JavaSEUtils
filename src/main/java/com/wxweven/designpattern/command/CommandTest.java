/**
 * @(#)CommandTest.java, Apr 23, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.command;

import org.junit.Test;

/**
 * @author wangxw03
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
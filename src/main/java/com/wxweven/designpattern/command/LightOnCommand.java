/**
 * @(#)LightOnCommand.java, Apr 23, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.command;

/**
 * 命令模式中的concrete command，持有receiver的引用，将操作委托给receiver
 *
 * @author wangxw03
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
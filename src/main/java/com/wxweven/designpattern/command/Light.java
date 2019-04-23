/**
 * @(#)Light.java, Apr 23, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.command;

/**
 * 命令模式中的receiver，最终负责执行具体的操作
 *
 * @author wangxw03
 */
public class Light {
    public void on() {
        System.out.println("turn on the light");
    }
}
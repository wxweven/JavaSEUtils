/**
 * @(#)SimpleRemoteController.java, Apr 23, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.command;

import lombok.Data;

/**
 * 命令模式中的invoker，持有command引用，并有一个通用方法触发command请求
 *
 * @author wangxw03
 */
@Data
public class SimpleRemoteControl {
    private Command command;

    public void onButtonPressed() {
        command.execute();
    }
}
package com.wxweven.designpattern.command;

import lombok.Data;

/**
 * 命令模式中的invoker，持有command引用，并有一个通用方法触发command请求
 *
 * @author wxweven
 */
@Data
public class SimpleRemoteControl {
    private Command command;

    public void onButtonPressed() {
        command.execute();
    }
}
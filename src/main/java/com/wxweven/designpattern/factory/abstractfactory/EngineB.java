package com.wxweven.designpattern.factory.abstractfactory;

/**
 * @author wxweven
 * @date 2019/4/22
 */
public class EngineB implements Engine {
    @Override
    public void createEngine() {
        System.out.println("制造-->EngineB");
    }
}

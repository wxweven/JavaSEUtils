package com.wxweven.designpattern.factory.abstractfactory;

/**
 * @author wxweven
 * @date 2019/4/22
 */
public class AirConditionA implements AirCondition {

    @Override
    public void createAirCondition() {
        System.out.println("制造-->AirConditionA");
    }
}

package com.wxweven.designpattern.factory.abstractfactory;

public interface AbstractFactory {
    //制造发动机
    Engine createEngine();

    //制造空调
    AirCondition createAirCondition();
} 
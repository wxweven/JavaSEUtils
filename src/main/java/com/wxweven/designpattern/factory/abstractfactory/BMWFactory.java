package com.wxweven.designpattern.factory.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//为宝马320系列生产配件
public class BMWFactory implements AbstractFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(BMWFactory.class);


    @Override
    public Engine createEngine() {
        LOGGER.info("制造-->EngineA");
        return new EngineA();
    }


    @Override
    public AirCondition createAirCondition() {
        LOGGER.info("制造-->AirConditionA");
        return new AirConditionA();
    }
} 

package com.wxweven.designpattern.factory.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//为宝马320系列生产配件
public class BenzFactory implements AbstractFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(BenzFactory.class);

    @Override
    public Engine createEngine() {
        LOGGER.info("制造-->EngineB");
        return new EngineB();
    }


    @Override
    public AirCondition createAirCondition() {
        LOGGER.info("制造-->AirConditionB");
        return new AirConditionB();
    }
} 

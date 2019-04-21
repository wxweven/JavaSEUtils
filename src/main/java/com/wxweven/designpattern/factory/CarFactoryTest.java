package com.wxweven.designpattern.factory;

import com.wxweven.designpattern.factory.abstractfactory.AbstractFactory;
import com.wxweven.designpattern.factory.abstractfactory.BMWFactory;
import com.wxweven.designpattern.factory.abstractfactory.BenzFactory;
import com.wxweven.designpattern.factory.data.CarEnum;
import com.wxweven.designpattern.factory.data.ICar;
import com.wxweven.designpattern.factory.factormethod.BMWCarFactory;
import com.wxweven.designpattern.factory.factormethod.BenzCarFactory;
import com.wxweven.designpattern.factory.factormethod.CarFactory;
import com.wxweven.designpattern.factory.factormethod.LandRoverCarFactory;
import com.wxweven.designpattern.factory.simple.CarSimpleFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单工厂模式测试
 *
 * @author wxweven
 * @version 1.0
 * @date 2017年3月8日
 * @email wxweven@qq.com
 * @blog wxweven.com
 * @Copyright: Copyright (c) wxweven 2009 - 2017
 */
public class CarFactoryTest {
    private static Logger logger = LoggerFactory.getLogger(CarFactoryTest.class);

    @Test
    public void testSimpleFactory() {
        ICar myCar = CarSimpleFactory.getCar(CarEnum.BENZ);
        logger.info("我的车：" + myCar.getName());
        myCar.drive();

        logger.info("今天高兴，换量车开吧...");
        myCar = CarSimpleFactory.getCar(CarEnum.BWM);
        logger.info("我的车：" + myCar.getName());
        myCar.drive();

        logger.info("今天要爬山，换量越野车吧...");
        myCar = CarSimpleFactory.getCar(CarEnum.LANDROVER);
        logger.info("我的车：" + myCar.getName());
        myCar.drive();
    }

    @Test
    public void testFactory() {
        CarFactory carFactory = new BenzCarFactory();
        ICar myCar = carFactory.createCar();
        logger.info("我的车：" + myCar.getName());
        myCar.drive();

        logger.info("今天高兴，换量车开吧...");
        carFactory = new BMWCarFactory();
        myCar = carFactory.createCar();
        logger.info("我的车：" + myCar.getName());
        myCar.drive();

        logger.info("今天要爬山，换量越野车吧...");
        carFactory = new LandRoverCarFactory();
        myCar = carFactory.createCar();
        logger.info("我的车：" + myCar.getName());
        myCar.drive();
    }

    @Test
    public void testAbstractFactory() {
        //生产宝马系列配件
        AbstractFactory factory = new BMWFactory();
        factory.createEngine();
        factory.createAirCondition();

        logger.info("-------------------");

        //生产奔驰系列配件
        factory = new BenzFactory();
        factory.createEngine();
        factory.createAirCondition();
    }
}

package com.wxweven.designpattern.factory.simple;

import com.wxweven.designpattern.factory.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单工厂模式
 *
 * @author wxweven
 * @version 1.0
 * @date 2017年3月8日
 * @email wxweven@qq.com
 * @blog wxweven.com
 * @Copyright: Copyright (c) wxweven 2009 - 2017
 */
public class CarSimpleFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarSimpleFactory.class);

    public static Car getCar(CarEnum carEnum) {
        switch (carEnum) {
            case BENZ:
                return new BenzCar();
            case BWM:
                return new BMWCar();
            case LANDROVER:
                return new LandRoverCar();
            default:
                return null;
        }
    }

    public static Car getCarByClass(Class c) {
        try {
            return (Car) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            LOGGER.error("CarSimpleFactory::getCarByClass 异常: c={}", c, e);
        }
        return null;
    }
}

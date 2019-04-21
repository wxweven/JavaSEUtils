package com.wxweven.designpattern.factory.factormethod;

import com.wxweven.designpattern.factory.data.ICar;
import com.wxweven.designpattern.factory.data.LandRoverCar;

/**
 * @author wxweven
 * @date 2019/4/22
 */
public class LandRoverCarFactory extends CarFactory {
    @Override
    public ICar createCar() {
        return new LandRoverCar();
    }
}

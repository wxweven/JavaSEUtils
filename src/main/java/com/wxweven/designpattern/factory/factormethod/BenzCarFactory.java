package com.wxweven.designpattern.factory.factormethod;

import com.wxweven.designpattern.factory.data.BenzCar;
import com.wxweven.designpattern.factory.data.ICar;

/**
 * @author wxweven
 * @date 2019/4/22
 */
public class BenzCarFactory extends CarFactory {
    @Override
    public ICar createCar() {
        return new BenzCar();
    }
}

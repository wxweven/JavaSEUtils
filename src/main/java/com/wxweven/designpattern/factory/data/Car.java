package com.wxweven.designpattern.factory.data;

/**
 * Car接口
 * @author wxweven
 * @date 2017年3月8日
 * @version 1.0
 * @email wxweven@qq.com
 * @blog wxweven.com
 * @Copyright: Copyright (c) wxweven 2009 - 2017
 */
public interface Car {

    /**
     * 获取Car名称
     * @return
     */
    String getName();

    /**
     * 开车方法
     */
    void drive();

}

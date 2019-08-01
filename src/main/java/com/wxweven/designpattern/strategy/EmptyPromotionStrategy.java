/**
 * @(#)EmptyPromotionStrategy.java, Aug 01, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.strategy;

/**
 * @author wxweven
 */
public class EmptyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");

    }
}
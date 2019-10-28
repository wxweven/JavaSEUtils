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
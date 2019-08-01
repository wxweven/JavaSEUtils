package com.wxweven.designpattern.strategy;

import org.junit.Test;

/**
 * Created by geely
 */
public class StrategyTest {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
//        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());
//
//        promotionActivity618.executePromotionStrategy();
//        promotionActivity1111.executePromotionStrategy();
//    }

    @Test
    public void test() {
        String promotionKey = "LIJIAN";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.executePromotionStrategy();
    }

    @Test
    public void test2() {
        String promotionKey = "MANJIAN";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.executePromotionStrategy();
    }

    @Test
    public void test3() {
        String promotionKey = "FANXIAN";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.executePromotionStrategy();
    }

    @Test
    public void test4() {
        String promotionKey = "fdsfsa";
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.executePromotionStrategy();
    }
}

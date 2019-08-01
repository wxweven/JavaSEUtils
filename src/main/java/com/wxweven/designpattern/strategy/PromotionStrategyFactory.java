/**
 * @(#)PromotionStrategyFactory.java, Aug 01, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wxweven
 */
public class PromotionStrategyFactory {
    private static final Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    private static final PromotionStrategy EMPTY_PROMOTION_STRATEGY = new EmptyPromotionStrategy();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN, new FanXianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN, new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN, new ManJianPromotionStrategy());
    }

    private interface PromotionKey {
        String LIJIAN = "LIJIAN";
        String MANJIAN = "MANJIAN";
        String FANXIAN = "FANXIAN";
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        return PROMOTION_STRATEGY_MAP.getOrDefault(promotionKey, EMPTY_PROMOTION_STRATEGY);
    }
}
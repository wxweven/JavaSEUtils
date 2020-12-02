/**
 * @(#)LC710BlackList.java, 11月 17, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.array;

import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wxweven
 */
public class LC710BlackList {

    // https://www.yuque.com/wxweven/yn3rzz/wmsx82

    private int N;
    private List<Integer> blackList;

    private int sz;
    private Map<Integer, Integer> val2Index = new HashMap<>();

    public LC710BlackList(int n, List<Integer> blackList) {
        N = n;
        this.blackList = blackList;

        // 最终数组中的元素个数
        sz = N - blackList.size();
        for (Integer black : blackList) {
            // 这里赋值多少都可以,目的仅仅是把键存进哈希表,方便快速判断数字是否在黑名单内
            val2Index.put(black, 1);
        }

        // 最后一个元素的索引
        int last = N - 1;

        // 将黑名单中的索引换到最后去
        for (Integer num : blackList) {
            // 如果 b 已经在区间 [sz, N)，可以直接忽略
            if (num > sz) {
                continue;
            }

            // 如果要换的最后一个元素是黑名单元素，就往前找
            while (val2Index.containsKey(last)) {
                last--;
            }

            // 将黑名单中的索引映射到合法数字
            val2Index.put(num, last);
            last--;
        }
    }

    private int pick() {
        // 随机选取一个索引
        int number = RandomUtils.nextInt(0, sz);

        // 这个索引命中了黑名单，需要被映射到其他位置
        if (val2Index.containsKey(number)) {
            return val2Index.get(number);
        }

        // 若没命中黑名单，则直接返回
        return number;
    }
}
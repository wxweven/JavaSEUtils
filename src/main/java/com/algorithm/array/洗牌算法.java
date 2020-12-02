/**
 * @(#)洗牌算法.java, 11月 26, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.array;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 洗牌算法 {

    private static final int N = 50_000_000;

    /**
     * https://www.yuque.com/wxweven/yn3rzz/rhr8me#by4zm
     */

    public void shuffle(int[] arr) {
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, RandomUtils.nextInt(0, i + 1));
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    @Test
    public void test() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            shuffle(arr);
            if (arr[0] == 4) {
                count++;
            }
        }

        System.out.println(count * 1.0 / N);
    }
}
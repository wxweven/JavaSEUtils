/**
 * @(#)二进制1的个数.java, 9月 10, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 二进制1的个数 {

    private int numOfOne(int num) {
        int n = Math.abs(num);

        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }

            n >>= 1;
        }

        return count;
    }

    @Test
    public void test() {
        int count = numOfOne(-4);
        System.out.println(count);
        Assert.assertEquals(1, count);
    }
}
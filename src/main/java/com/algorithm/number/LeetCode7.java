package com.algorithm.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wxweven
 */
public class LeetCode7 {
    /*
     * 将数字翻转
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     * Example 2:
     *
     * Input: -123
     * Output: -321
     * Example 3:
     *
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range
     * : [−231,  231 − 1]. For the purpose of this problem,
     * assume that your function returns 0 when the reversed integer overflows.
     */

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int num = x % 10;
            int newRes = res * 10 + num;

            // 这一步是为了判断是否越界
            // 上一步乘以10+num后，如果越界，除以10肯定得不到原来的数
            if (newRes / 10 != res) {
                return 0;
            }

            res = newRes;

            x = x / 10;
        }

        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(123, reverse(321));
        Assert.assertEquals(-123, reverse(-321));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));

        TimeUnit timeUnit = TimeUnit.MINUTES;

        long l = timeUnit.toSeconds(2);
        System.out.println(l);

    }
}
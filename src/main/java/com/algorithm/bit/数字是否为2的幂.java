package com.algorithm.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 数字是否为2的幂 {

    /**
     * 将2的幂次方写成二进制形式后，很容易就会发现有一个特点：二进制中只有一个1，并且1后面跟了n个0；
     * 因此问题可以转化为判断1后面是否跟了n个0就可以了。
     * 如果将这个数减去1后会发现，仅有的那个1会变为0，而原来的那n个0会变为1；
     * 因此将原来的数与去减去1后的数字进行与运算后会发现为零。
     */

    private boolean is2Times(int n) {
        return (n & n - 1) == 0;
    }

    @Test
    public void test() {
        Assert.assertFalse(is2Times(10));
        Assert.assertTrue(is2Times(8));
    }
}
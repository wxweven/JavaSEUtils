package com.algorithm.number;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://shimo.im/docs/VkXkGTtYGchxDqyd
 */
public class NumberOfDigitalOne {
    public int count(int n) {
        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0) {
            int weight = round % 10;
            round /= 10;
            count += round * base;
            if (weight == 1)
                count += (n % base) + 1;
            else if (weight > 1)
                count += base;
            base *= 10;
        }
        return count;
    }

    @Test
    public void test() {
        NumberOfDigitalOne obj = new NumberOfDigitalOne();

        int count = obj.count(12);
        System.out.println(count);
        Assert.assertEquals(5, count);

        int count2 = obj.count(534);
        System.out.println(count2);
        Assert.assertEquals(214, count2);
    }
}

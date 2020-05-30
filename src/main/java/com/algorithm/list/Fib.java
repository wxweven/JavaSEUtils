package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

public class Fib {
    private long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        long a = 1;
        long b = 1;
        long res = 0;

        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }

    @Test
    public void test() {
        long res = fibonacci(5);
        Assert.assertEquals(5, res);

        res = fibonacci(6);
        System.out.println("f(6)=" + res);
        Assert.assertEquals(8, res);
    }
}

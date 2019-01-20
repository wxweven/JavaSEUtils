package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

public class Fib {
   private long fibonacci(int n) {
        if(n <= 2) {
            return 1;
        }
        long one = 1;
        long two = 1;
        long res = 0;

        for(int i = 3; i <= n; i++) {
            res = one + two;

            one = two;
            two = res;
        }

        return res;
    }

    @Test
    public void test(){
     long res =  fibonacci(5);
        Assert.assertEquals(5, res);

        res =  fibonacci(6);
        System.out.println("f(6)="+res);
        Assert.assertEquals(8, res);
    }
}

package com.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wxweven
 * @date 2019/2/19
 */
public class ArrayPairSum {
    @Test
    public void test() {
        int res = arrayPairSumSoultion(new int[]{4, 2, 1, 3});
        System.out.println(res);
        ArrayPairSum.class.getDeclaredMethods();
    }

    public static int arrayPairSumSoultion(int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result += arr[i];
        }
        return result;
    }
}

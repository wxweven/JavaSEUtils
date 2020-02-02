package com.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

public class 数字在排序数组中出现的次数 {
    public static int getTimes(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;

        int first = getFirstIndex(arr, num, 0, len - 1);
        int last = getLastIndex(arr, num, 0, len - 1);

        if (first == -1 || last == -1) {
            return 0;
        }

        return last - first + 1;
    }

    public static int getFirstIndex(int[] arr, int num, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) >> 1;

        if (arr[middle] == num) {
            if (middle == 0 || arr[middle - 1] < num) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (arr[middle] < num) {
            start = middle + 1;

        } else {
            end = middle - 1;
        }

        return getFirstIndex(arr, num, start, end);

    }

    public static int getLastIndex(int[] arr, int num, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) >> 1;

        if (arr[middle] == num) {
            if (middle == end || arr[middle + 1] > num) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (arr[middle] < num) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getLastIndex(arr, num, start, end);
    }

    @Test
    public void test() {
        int[] arrs = new int[]{1, 2, 3, 3, 3, 6, 7};
        int times = getTimes(arrs, 3);
        System.out.println(times);
        Assert.assertEquals(3, times);

        times = getTimes(arrs, 4);
        System.out.println(times);
        Assert.assertEquals(0, times);
    }
}

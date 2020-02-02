package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class 约瑟夫环 {
    public static int lastRemaining(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        // 要删除元素的位置
        int idx = 0;

        int cur = -1;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }

    @Test
    public void test() {
        int[] arr = new int[]{0, 1, 2, 3, 4};
        int least = lastRemaining(arr, 3);
        System.out.println(least);
        Assert.assertEquals(3, least);
    }
}

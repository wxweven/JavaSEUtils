package com.algorithm.array;

public class MergeTwoSortedArray {
    /**
     * 合并两个排序数组到一个新的数组（新数组也是排序的）
     */

    public int[] merge(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }

        int aLen = a.length;
        int bLen = b.length;

        int[] c = new int[aLen + bLen];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < aLen && j < bLen) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < aLen) {
            c[k++] = a[i++];
        }

        while (j < bLen) {
            c[k++] = b[j++];
        }

        return c;
    }
}

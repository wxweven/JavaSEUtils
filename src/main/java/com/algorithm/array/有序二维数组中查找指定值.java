package com.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 顺时针打印二维数组
 *
 * @author wxweven
 * @date 2018/10/26
 */
public class 有序二维数组中查找指定值 {

    @Test
    public void test() {
        int[][] testArr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        boolean res1 = find(testArr, 2);
        boolean res2 = find(testArr, 6);
        boolean res3 = find(testArr, 13);
        boolean res4 = find(testArr, 15);
        boolean res5 = find(testArr, 30);
        boolean res6 = find(testArr, 14);

        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
        Assert.assertTrue(res3);
        Assert.assertTrue(res4);
        Assert.assertFalse(res5);
        Assert.assertFalse(res6);
    }

    public static boolean find(int[][] arr, int number) {
        if (arr == null) {
            return false;
        }

        // 数组行数
        int rows = arr.length;
        if (rows == 0) {
            return false;
        }

        // 数组列数
        int cols = arr[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int arrNumber = arr[row][col];
            if (arrNumber == number) {
                return true;
            }

            if (arrNumber > number) {
                col--;
            } else {
                row++;
            }
        }

        return col == 0;
    }
}

package com.algorithm.array;

/**
 * @author wxweven
 * @Description: 输入一个整形数组，数组里可能有正数也可能有负数。数组中连续的一个或多个整数组成一个子数组，
 * 每个子数组都有一个和。求所有子数组的和的最大值。要求时间复杂度为O(n)。 例如：输入的数组为1, -2, 3, 10,
 * -4, 7, 2, -5 和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

        int subArraySum = maxSum(arr);
        int subArraySum2 = maxSum(arr2);
        System.out.println("最大的子数组之和是：" + subArraySum);
        System.out.println("最大的子数组之和是：" + subArraySum2);
    }

    private static int maxSum(int[] arr) {
        int maxSum = 0;
        int temp = maxSum;

        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];

            if (temp < 0) {
                temp = 0;
            }

            if (temp > maxSum) {
                maxSum = temp;
            }
        }

        if (maxSum <= 0) {
            // 防止数组全部是负数
            maxSum = maxArray(arr);
        }

        return maxSum;
    }

    private static int maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }
}

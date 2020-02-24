package com.algorithm.array;

/**
 * @author wxweven
 */
public class LeetCode189 {
    /*
     * 将数组旋转n次
     * https://www.youtube.com/watch?v=06-7_TTlkAw&feature=emb_title
     *
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: [-1,-100,3,99] and k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     */

    // 利用栈先进后出的思想
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        int len = nums.length;

        k = k % len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}
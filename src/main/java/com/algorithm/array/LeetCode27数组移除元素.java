/**
 * @(#)LeetCode27数组移除元素.java, 10月 04, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.array;

/**
 * @author wxweven
 */
public class LeetCode27数组移除元素 {

    /*
     * 题目要求：把nums中所有值为val的元素原地删除(数组不一定排序)
     *
     * 解题思路：
     * 我们让慢指针slow走在后面，快指针fast走在前面探路，
     * 找到指定的元素就告诉slow并让slow前进一步。
     * 这样当fast指针遍历完整个数组nums后，nums[0..slow]留下来的元素。
     *
     * 输入：nums = [0,1,4,0,2]，val=0
     * 输出：删除0后，数组的长度 3，数组nums = [1,4,2]
     */
    int removeEle(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int slow = 0, fast = 0;
        while (fast < len) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
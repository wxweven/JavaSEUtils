package com.algorithm.array;

public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 循环退出条件为 left 和 right 相邻，而不是普通二分查找中的 left 和right 相等
        // 视频讲解: https://www.youtube.com/watch?v=xSs-R1onSpc
        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target <= nums[left]) {
            return left;
        } else if (target > nums[right]) {
            return right + 1;
        } else {
            return right;
        }
    }
}

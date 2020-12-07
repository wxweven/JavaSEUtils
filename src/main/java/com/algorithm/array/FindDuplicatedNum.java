package com.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicatedNum {

    public int find(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }

            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }

            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }

    @Test
    public void test() {
        int[] arr1 = new int[]{2, 3, 1, 0, 2, 5, 3};
        Assert.assertEquals(2, find(arr1));

        int[] arr2 = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertEquals(11, find(arr2));
    }
}

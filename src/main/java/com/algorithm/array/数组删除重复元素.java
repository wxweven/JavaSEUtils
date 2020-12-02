/**
 * @(#)数组删除重复元素.java, 7月 20, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 数组删除重复元素 {

    /**
     * nums = [1 1 2]
     * 删除后得到 [1 2]
     * 只能原地操作，空间复杂度O(1)
     * 返回删除后，新数组的长度
     */

    /**
     * 我们让慢指针 slow ⾛左后⾯， 快指针 fast ⾛在前⾯探路， 找到⼀个不
     * 重复的元素就告诉 slow 并让 slow 前进⼀步，让slow存下这个元素
     * （当slow和fast一样时，不需要做任何处理，因为slow已经存下了这个元素）。
     * 这样当 fast 指针遍历完整个数组 nums 后， nums[0..slow] 就是不重复元素， 之后的所有元素都
     * 是重复元素
     *
     * @param arr
     * @return
     */
    public static int removeDuplicated(int[] arr) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;
        int slow = 0;
        int fast = 1;

        while (fast < len) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 1, 2};

        int len = removeDuplicated(arr);
        Assert.assertEquals(2, len);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(2, arr[1]);

        int[] arr2 = new int[]{1, 2, 2, 3};

        int len2 = removeDuplicated(arr2);
        Assert.assertEquals(3, len2);
        Assert.assertEquals(1, arr2[0]);
        Assert.assertEquals(2, arr2[1]);
        Assert.assertEquals(3, arr2[2]);
    }

}
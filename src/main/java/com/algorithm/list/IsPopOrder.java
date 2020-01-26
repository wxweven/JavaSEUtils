package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/*
 * 面试题22：栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示压入顺序，判断第二个序列是否为弹出顺序.假设入栈所有数字均不相等。
 * 思路：借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，
 * 所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，
 * 如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int popIndex = 0;
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            while (!stack.isEmpty() && stack.peek() == b[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        int[] c = {4, 5, 3, 1, 2};
        boolean popOrder1 = isPopOrder(a, b);
        System.out.println(popOrder1);
        Assert.assertTrue(popOrder1);

        boolean popOrder2 = isPopOrder(a, c);
        System.out.println(popOrder2);
        Assert.assertFalse(popOrder2);
       }
}

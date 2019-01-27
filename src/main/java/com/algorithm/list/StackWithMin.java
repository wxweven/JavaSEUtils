package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/*
 * 面试题21：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的Min函数，在该栈中,min,push,pop的时间复杂度都是O(1)。
 * 思路：用两个栈，一个正常处理，另一个存最小值。入栈时，如果值比最小栈栈顶的值小，则入，否则再入一次最小栈栈顶值。每次取min时就取最小栈栈顶。
 */
public class StackWithMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int number) {
        stack.push(number);

        int min = number;
        if (!minStack.isEmpty()) {
            Integer stackTop = minStack.peek();
            min = min < stackTop ? min : stackTop;
        }

        minStack.push(min);
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }

        return -1;
    }

    @Test
    public void test() {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        Assert.assertEquals(3, stack.min());
        stack.push(4);
        Assert.assertEquals(3, stack.min());

        stack.push(2);
        Assert.assertEquals(2, stack.min());

        stack.push(1);
        Assert.assertEquals(1, stack.min());

        stack.pop();
        Assert.assertEquals(2, stack.min());
    }
}

package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/*
 * 面试题5：输入一个链表的头结点，从尾到头打印每个节点的值。（打印操作一般不改变链表的结构）
 * 思路1：典型的后进先出，用栈。
 */
public class 从尾到头打印单链表 {

    // 从尾到头打印,用栈。
    public static void print(ListNode headNode) {
        if (headNode == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode.val);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        print(head);
    }

}


package com.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class 反转单链表 {

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(5));
        System.out.println("原链表：");
        ListNode.print(head);

        ListNode newHead = reverse(head);

        System.out.println("反转后链表：");
        ListNode.print(newHead);

        Assert.assertEquals(5, newHead.val);

        head = ListNode.createLinkedList(Arrays.asList(5, 89, 60));
        newHead = reverse(head);
        Assert.assertEquals(60, newHead.val);
    }
}

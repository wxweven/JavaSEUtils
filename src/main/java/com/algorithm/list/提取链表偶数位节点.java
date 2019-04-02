package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;

public class 提取链表偶数位节点 {

    @Test
    public void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(1, 90));

        ListNode.print(head);

        ListNode newHead = getEvenHead(head);
        ListNode.print(newHead);
    }

    public static ListNode getEvenHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode newHead = head.next;
        ListNode slow = head;
        ListNode fast = head.next;

        while (true) {
            if (fast == null) {
               break;
            } else {
                slow.next = fast.next;
                slow = fast.next;
            }

            if (slow == null) {
                break;
            }else {
                fast.next = slow.next;
                fast = slow.next;
            }
        }

        return newHead;
    }
}

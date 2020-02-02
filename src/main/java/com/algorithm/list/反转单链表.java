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

    // 递归方式
    public static ListNode reverse2(ListNode head) {

        /*如果是空链或者只是单个节点的链表  将直接返回*/
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverse(head.next);/*找到了最后一个   也就是5   当前head为4  reverse为5*/
        head.next.next = head;/* 1-->2-->3-->4-->5   变为   5-->4  1-->2-->3-->4  此时4指向5  5 也指向4*/
        head.next = null;  /*4-->null    5-->4-->null  1-->2-->3-->4 */
        return reverse;    /*返回5-->4-->null*/
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

        System.out.println();

        head = ListNode.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("原链表：");
        ListNode.print(head);
        newHead = reverse2(head);

        System.out.println("反转后链表：");
        ListNode.print(newHead);
        Assert.assertEquals(5, newHead.val);
    }
}

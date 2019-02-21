package com.algorithm.list;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * 头插法建立链表,这里假设头结点就是第一个结点。
     *
     * @return
     */
    public static ListNode createLinkedList(List<Integer> dataList) {
        if (CollectionUtils.isEmpty(dataList)) {
            System.out.println("输入有误！");
            return null;
        }

        ListNode head = null;

        for (int i = dataList.size() - 1; i >= 0; i--) {
            ListNode p = new ListNode(dataList.get(i));
            p.next = head;
            head = p;
        }

        return head;
    }

    /**
     * 正序打印链表
     *
     * @param head 链表头指针
     */
    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("打印方法的输入为空");
            return;
        }

        int i = 0;
        while (head != null) {
            if (i != 0) {
                System.out.print("->");
            }
            System.out.print(head.val);
            head = head.next;
            i++;
        }

        System.out.println();
    }
}

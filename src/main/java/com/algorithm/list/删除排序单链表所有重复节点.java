package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wxweven
 * @date 2019/2/13
 */
public class 删除排序单链表所有重复节点 {
    @Test
    public void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(1, 2, 3, 3, 4, 4, 5));

        ListNode head1 = deleteAllDuplicates(head);
        ListNode.print(head1);

        ListNode head2 = deleteDuplicates(head);
        ListNode.print(head2);
    }

    /*
     * Given a sorted linked list,
     * delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * Example 1:
     *      Input: 1->2->3->3->4->4->5
     *      Output: 1->2->5
     * Example 2:
     *      Input: 1->1->1->2->3
     *      Output: 2->3
     */
    public static ListNode deleteAllDuplicates(ListNode head) {
        /*
         * 链表为空或者只有一个节点，不用处理，直接返回
         */
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * 解决这个问题的精妙之处：在头结点前插入一个『多余』的节点，
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (cur.val != next.val) {
                prev = cur;
                cur = next;
                next = next.next;
            } else {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }

                prev.next = next;
                cur = next;
                next = next == null ? null : next.next;
            }
        }

        return dummy.next;

    }

    /*
     *
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * Example 1:
     *   Input: 1->1->2
     *   Output: 1->2
     *
     * Example 2:
     *   Input: 1->1->2->3->3
     *   Output: 1->2->3
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }

            next = next.next;
        }

        return head;
    }
}

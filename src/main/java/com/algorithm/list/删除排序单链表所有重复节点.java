package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wxweven
 * @date 2019/2/13
 */
public class 删除排序单链表所有重复节点 {
    @Test
    public void test(){
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
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                prev = slow;
                slow = fast;
                fast = fast.next;
            } else {
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }

                prev.next = fast;
                slow = fast;
                fast = fast == null ? null : fast.next;
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
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null){
            if(fast.val == slow.val){
                slow.next = fast.next;
            } else {
                slow = fast;
            }

            fast = fast.next;
        }

        return head;
    }
}

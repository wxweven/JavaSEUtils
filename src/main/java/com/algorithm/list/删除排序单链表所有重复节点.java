package com.algorithm.list;

/**
 * @author wxweven
 * @date 2019/2/13
 */
public class 删除排序单链表所有重复节点 {
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

    public static ListNode deleteDuplicates(ListNode head) {
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
            if (slow.value != fast.value) {
                prev = slow;
                slow = fast;
                fast = fast.next;
            } else {
                while (fast != null && fast.value == slow.value) {
                    fast = fast.next;
                }

                prev.next = fast;
                slow = fast;
                fast = fast == null ? null : fast.next;
            }
        }

        return dummy.next;

    }


}

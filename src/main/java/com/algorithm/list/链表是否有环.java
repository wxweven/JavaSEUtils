package com.algorithm.list;

/**
 * @author wxweven
 */
public class 链表是否有环 {

    public static boolean hasCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
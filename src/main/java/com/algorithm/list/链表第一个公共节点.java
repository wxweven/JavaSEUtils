package com.algorithm.list;

public class 链表第一个公共节点 {
    public ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int len1 = getLen(head1);
        int len2 = getLen(head2);

        ListNode fast = len1 > len2 ? head1 : head2;
        ListNode slow = len1 > len2 ? head2 : head1;
        int diff = Math.abs(len1 - len2);

        for (int i = 0; i < diff; i++) {
            fast = fast.next;
        }

        while (fast != null
                && slow != null
                && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

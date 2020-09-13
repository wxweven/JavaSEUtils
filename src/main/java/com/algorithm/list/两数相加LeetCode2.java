/**
 * @(#)两数相加LeetCode2.java, 9月 06, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.list;

/**
 * @author wxweven
 */
public class 两数相加LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int sum = 0;

        while (p != null || q != null) {
            if (p != null) {
                sum += p.val;
                p = p.next;
            }

            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if (sum > 0) {
            cur.next = new ListNode(sum);
        }

        return dummy.next;
    }

}
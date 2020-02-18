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

        // 链表删除节点的关键：得找到前一个节点
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (cur.val != next.val) {
                // 如果next的值和当前节点的值不相等，说明不是重复节点，往后找
                // 即每个指针都往后移
                prev = cur;
                cur = next;
                next = next.next;
            } else {
                // next的值和当前的相等了，说明开始出现重复节点；
                // 这里的循环是为了找到所有的重复节点：当next.val 与 cur.val 不等时，找到了所有重复的节点
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }

                // prev之后、next之前的节点都是重复的，直接把所有的重复节点删除
                prev.next = next;
                // cur 和 next 往后移，注意边界
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

    /**
     * 我们只需要一个指针，即下面代码中的cur，从head开始挨个遍历链表节点（所以链表已经排序好这个前提很重要），
     * 对于每个cur，将其与其后继的节点值比较，如果相同，说明这个后继需要删除，
     * 对链表而言，操作则相当简单，直接将cur的后继改为当前后继的后继即可。
     * 如果不同，说明没有与当前节点值重复的了，直接将当前节点后移即可，即将cur更新为当前节点的后继。
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

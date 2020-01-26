package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;

/*
 * 面试题15：链表中倒数第K个结点
 * 输入一个单链表，输出该链表中倒数第k个结点。链表的尾结点是倒数第1个结点。例如一个链表有4个结点，依次是1,2,3,4,这个链表的倒数第3个结点是2。
 * 思路1：假设链表有n个结点，那么倒数第k个结点就是从头开始的第n-k+1个结点。所以一种方法是遍历两次链表，第一次得到n，第二次找到k。
 * 思路2：更好的方法是只需遍历一次，我们定义两个指针，第一个指针从头开始走到倒数个第K个节点，第二个指针从头开始走到最后一个节点，
 * 那么第二个指针比第一个指针多走了 k-1 步；假设现在让第二个指针先走 k-1 步，那么当第二个指针到达尾结点时，第一个指针刚好在倒数第k个。
 * 相关题1：求链表的中间结点。如果是结点数是偶数，返回中间两个任意一个。也可以用两个指针，一个指针一次走一步，另一个走两步，走得快的到末尾时，走得慢的刚好在中间结点。
 * 相关题2：判断单链表是否形成环形结构。还是一个指针走一步，一个指针走两步，走得快的指针如果追上走得慢的指针，那么就是环形的。如果走得快的走到了末尾都没有追上，说明不是环形。
 */
public class 链表倒数第k个节点 {

    // 找到倒数第k个
    public static ListNode find(ListNode headNode, int k) {
        if (headNode == null || k <= 0) {
            System.out.println("输入为空或k有误");
            return null;
        }
        ListNode fast = headNode;
        ListNode slow = headNode;

        /*
         * 快指针先走k-1步
         * 为什么是先先走 k-1步：
         * 假设在某一时刻，第一个指针从头开始走到倒数个第K个节点，第二个指针从头开始走到最后一个节点，
         * 那么第二个指针比第一个指针多走了 k-1 步；所以，得让第二个指针先走 k-1 步
         */
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                // 防止 k 过大(大于n)，走完了列表，就会产生NPE
                fast = fast.next;
            } else {
                System.out.println("输入k有误");
                return null;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    @Test
    public  void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(5,67,89,90));
        ListNode.print(head);

        int k = 2;
        ListNode foundNode = find(head, k);
        if (foundNode == null) {
            System.out.println("未找到倒数第" + k + "个节点");
            return;
        }

        System.out.println("倒数第" + k + "个是:" + foundNode.val);
    }
}

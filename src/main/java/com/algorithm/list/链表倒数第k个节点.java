package com.algorithm.list;

import org.junit.Test;

import java.util.Arrays;

/*
 * 面试题15：链表中倒数第K个结点
 * 输入一个单链表，输出该链表中倒数第k个结点。链表的尾结点是倒数第1个结点。例如一个链表有4个结点，依次是1,2,3,4,这个链表的倒数第3个结点是2。
 * 思路1：假设链表有n个结点，那么倒数第k个结点就是从头开始的第n-k+1个结点。所以一种方法是遍历两次链表，第一次得到n，第二次找到k。
 * 思路2：更好的方法是只需遍历一次，我们定义两个指针，第一个指针从头开始走k-1步，从第k步开始，第二个指针也开始从头开始走，两个指针的距离为k-1，当第一个指针到达尾结点时，第二个指针刚好在倒数第k个。
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
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;

        /*
         * 快指针先走k-1步
         * 为什么是先先走 k-1步：假设链表的长度为n
         * 1. 链表的倒数第k个节点，正着数就是第 n-k+1 个节点
         * 2. 慢指针走到倒数第k个节点，也就是正着走了 n-k+1 步，那么快指针第二次也走了 n-k+1步
         *    因为快指针遍历了真个链表，所以快指针总共走了 n 步，那么第一次走的(也就是先走的)步数是：
         *    n - (n-k+1) = k-1
         */
        for (int i = 0; i < k - 1; i++) {
            if (fastNode.next != null) {
                // 防止 k 过大(大于n)，走完了列表，就会产生NPE
                fastNode = fastNode.next;
            } else {
                System.out.println("输入k有误");
                return null;
            }
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;
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

package com.algorithm.list;
/*
 * 面试题13：在O(1)时间删除链表结点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 思路：一般思路是从头开始遍历，这样复杂度是O(n)不合题意。我们的方法是把该节点的值设为该节点下一个节点的值，然后让该节点指向下下一个节点。
 * 这样会有三种情况：1，要删除的节点不是尾节点。2，链表只有一个节点3，要删除的节点是尾节点，只能从头到尾遍历了。最后平均一下复杂度还是O(1)。
 */

public class O1时间删除单链表节点 {
    public static void delete(ListNode headNode, ListNode toBeDeleted) {
        if (headNode == null || toBeDeleted == null) {
            System.out.println("都是null");
            return;
        }


        if (toBeDeleted.next != null) {
            //1,要删除的节点不是尾节点
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else if (headNode == toBeDeleted) {
            //2，链表只有一个节点，要把头指针设为NULL。
            headNode = null;
        } else {
            //3，要删除的节点是尾节点
            while (headNode.next != toBeDeleted) {
                headNode = headNode.next;
            }
            headNode.next = null;
        }
    }


}

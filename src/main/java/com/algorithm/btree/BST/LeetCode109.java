package com.algorithm.btree.BST;

import com.algorithm.list.ListNode;
import com.algorithm.btree.TreeNode;

public class LeetCode109 {
    /*
     * 将排序的链表转化为BST
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted linked list: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */

    /**
     * 思路：这题跟108一样的思路，数组的中间数就是二叉树的根，左边的数据就是左子树，右边就是右子树
     * 然后递归处理；不同的是，在数组中，中间节点很好得到，而链表的中间节点却比较麻烦。
     * 可以利用快慢指针来得到链表的中间节点
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return helper(head, null);
    }

    // 注意，这里包含start，但是不包含end
    public TreeNode helper(ListNode start, ListNode end) {
        // 递归边界条件
        if (start == end) {
            return null;
        }

        // 得到链表的中间节点
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow就是链表的中间节点
        TreeNode root = new TreeNode(slow.val);

        // 链表的递归是左闭右开，所以left是(start -> slow (slow不包含))
        // 但是right必须是(slow.next -> end)
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);

        return root;
    }
}

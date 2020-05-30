package com.algorithm.btree;

import java.util.Stack;

/**
 * @author wxweven
 */
public class LeetCode114 {
    /*
     * 将二叉树按照先序遍历方式转化成链表
     *
     * IGiven a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */

    // 利用栈先进后出的思想
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.right != null) {
                // 先把右节点入栈
                stack.push(cur.right);
            }

            if (cur.left != null) {
                // 再把左节点入栈
                stack.push(cur.left);
            }

            if (!stack.isEmpty()) {
                // 下一个节点就是当前栈顶的节点，但是注意是peek，不能是pop
                // 如果是pop，下一轮循环就拿不到关联的节点了
                cur.right = stack.peek();
            }

            // 从示意图可以看出，二叉树左节点都为null
            cur.left = null;
        }

    }
}
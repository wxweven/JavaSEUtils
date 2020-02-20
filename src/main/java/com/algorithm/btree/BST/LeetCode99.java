package com.algorithm.btree.BST;

import com.algorithm.btree.TreeNode;

/**
 * @author wxweven
 */
public class LeetCode99 {
    /*
     * 题目描述：
     * Two elements of a binary search tree (BST) are swapped by mistake.
     *
     * Recover the tree without changing its structure.
     *
     * input
     *   3
     *  / \
     * 1   4
     *    /
     *   2
     *
     * output
     *    2
     *  / \
     * 1   4
     *    /
     *   3
     *
     * 也就是 3 和 2 交换
     *
     * 解题思路：
     * BST 的中序遍历，刚好就是从小到大排列，1 2 3 4
     * 现在排序的序列是 1 3 2 4，那么我们就要找到乱序的两个数
     *
     * 举个例子，假设 正常的序列是 0 1 2 3 5 6 8 9
     * 8 和 1 发生了交换，现在的序列是 0 8 2 3 5 6 1 9
     *
     * 第一个乱序数，就是『第一次』前一个数比后一个数大的那个『前一个数』
     * 第二个乱序数，就是『最后一次』前一个数比后一个数大的那个『后一个数』
     *
     *
     */


    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // 中序遍历
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        // 中序遍历，先处理左节点
        helper(root.left);

        // 处理根节点
        if (prev != null && prev.val > root.val) {
            // 前一个节点的值比当前节点值大，说明发生了乱序

            if (first == null) {
                // 第一个乱序数，就是『第一次』前一个数比后一个数大的那个『前一个数』
                // 所以，只有在first为null的时候，才赋值
                first = prev;
            }

            // 第二个乱序数，就是『最后一次』前一个数比后一个数大的那个『后一个数』
            // 所以，每次将second赋值为root即可
            second = root;
        }

        // prev 指针后移
        prev = root;

        // 最后处理右节点
        helper(root.right);
    }

}
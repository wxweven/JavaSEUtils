package com.algorithm.btree;

/**
 * @author wxweven
 */
public class LeetCode101 {
    /*
     * 题目大意，就是判断二叉树是否为中心对称
     *
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * But the following [1,2,2,null,3,null,3] is not:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        // 递归思想：左边的左边和右边的右边相等 且 左边的右边和右边的左边相等
        return helper(left.left, right.right)
                && helper(left.right, right.left);
    }
}
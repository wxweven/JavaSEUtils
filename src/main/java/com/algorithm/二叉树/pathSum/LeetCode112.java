package com.algorithm.二叉树.pathSum;

import com.algorithm.二叉树.TreeNode;

/**
 * @author wxweven
 */
public class LeetCode112 {
    /*
     * 判断二叉树是否存在指定和的路径（从根节点到叶子节点）
     *
     * Given a binary tree and a sum, determine if the tree has a
     * root-to-leaf path such that adding up all the values along the path equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}

package com.algorithm.btree.preorder;

import com.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxweven
 */
public class LeetCode144 {
    /*
     * 二叉树先序遍历
     *
     * Given a binary tree, return the preorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,2,3]
     */

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);

        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        res.add(root.val);

        helper(root.left);
        helper(root.right);
    }
}
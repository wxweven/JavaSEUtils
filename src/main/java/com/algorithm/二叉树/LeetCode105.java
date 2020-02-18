/**
 * @(#)LeetCode105.java, Feb 16, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxweven
 */
public class LeetCode105 {
    /*
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 题目概述：给定二叉树的先序遍历和中序遍历，构造这颗二叉树
     */

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder,
                           int preStart,
                           int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = map.get(preorder[preStart]);

        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd);

        return root;

    }
}
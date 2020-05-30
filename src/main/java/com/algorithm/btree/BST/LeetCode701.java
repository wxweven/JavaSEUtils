package com.algorithm.btree.BST;

import com.algorithm.btree.TreeNode;

public class LeetCode701 {
    /*
     * 题目大意：BST插入节点
     *
     * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
     * insert the value into the BST. Return the root node of the BST after the insertion.
     * It is guaranteed that the new value does not exist in the original BST.
     *
     * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
     * You can return any of them.
     *
     * For example,
     *
     * Given the tree:
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     * And the value to insert: 5
     * You can return this binary search tree:
     *
     *          4
     *        /   \
     *       2     7
     *      / \   /
     *     1   3 5
     * This tree is also valid:
     *
     *          5
     *        /   \
     *       2     7
     *      / \
     *     1   3
     *          \
     *           4
     */

    // 递归做法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);

        if (root == null) {
            return node;
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    // 迭代做法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);

        if (root == null) {
            return node;
        }

        TreeNode cur = root;

        while (true) {
            if (val < cur.val) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = node;
                    break;
                }
            } else if (val > cur.val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = node;
                    break;
                }
            }
        }

        return root;
    }
}

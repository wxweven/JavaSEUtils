package com.algorithm.btree.pathSum;

import com.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wxweven
 */
public class LeetCode113 {

    /*
     * 求二叉树指定和的所有路径
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
     *  /  \    / \
     * 7    2  5   1
     * Return:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }

        Stack<Integer> nodes = new Stack<>();

        helper(root, sum, nodes);

        return res;
    }

    public void helper(TreeNode root, int target, Stack<Integer> nodes) {
        if (root == null) {
            return;
        }

        int val = root.val;
        nodes.add(val);

        if (isLeaf(root) && val == target) {
            res.add(new ArrayList<>(nodes));
        }

        helper(root.left, target - val, nodes);
        helper(root.right, target - val, nodes);

        nodes.pop();
    }

    private int getSum(Stack<Integer> nodes) {
        return nodes.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

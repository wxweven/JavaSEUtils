package com.algorithm.btree.postorder;


import com.algorithm.btree.TreeNode;

public class LeetCode124 {

    /**
     * 题目大意：求二叉树中和最大的一条路径（该路径不一定要经过root节点）
     * Binary Tree Maximum Path Sum
     *
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
     * along the parent-child connections.
     *
     * The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // same method with 124,687 and 543

    // 定义最终的结果
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        helper(root);

        return res;
    }

    public int helper(TreeNode root){
        // 处理边界
        if(root==null){
            return 0;
        }

        // 后序遍历中，先处理左节点
        int left = Math.max(0,helper(root.left));
        // 再处理右节点
        int right = Math.max(0,helper(root.right));


        // 这一步是最终结果的处理
        res = Math.max(res, left + right + root.val);

        // 这一步是递归函数的返回值，跟上面的最终结果要区分开
        return Math.max(left, right) + root.val;
    }

}

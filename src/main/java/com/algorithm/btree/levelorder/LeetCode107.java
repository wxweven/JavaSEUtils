package com.algorithm.btree.levelorder;

import com.algorithm.btree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {
    /*
     * 二叉树层次遍历，从下往上
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its bottom-up level order traversal as:
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            // 每一次while循环，代表一层

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i=0;i<size;i++){
                // 每一次for循环，代表当前层的一列

                // 层次遍历，记住，一定是在for循环里面来poll
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if(cur.left!=null){
                    queue.offer(cur.left);
                }

                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }

            // 每次都加到最前面，即“后来居上”，正好就是“从下往上遍历”
            res.add(0, list);
        }

        return res;
    }
}

package com.algorithm.btree.levelorder;

import com.algorithm.btree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return depth;
    }
}

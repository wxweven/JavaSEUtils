package com.algorithm.btree.levelorder;

import com.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wxweven
 */
public class 二叉树的最小高度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int curSize = queue.size();

            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (isLeaf(node)) {
                    return depth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.initTree();

        int minDepth = minDepth(root);
        Assert.assertEquals(3, minDepth);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
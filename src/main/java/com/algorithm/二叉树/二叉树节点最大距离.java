package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

public class 二叉树节点最大距离 {
    public static int getLongestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curPath = getDepth(root.left) + getDepth(root.right);

        int leftPath = getLongestPath(root.left);
        int rightPath = getLongestPath(root.right);

        return Math.max(curPath, Math.max(leftPath, rightPath));

    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.initTree();

        int longestPath = getLongestPath(root);
        System.out.println(longestPath);

        Assert.assertEquals(5, longestPath);
    }
}

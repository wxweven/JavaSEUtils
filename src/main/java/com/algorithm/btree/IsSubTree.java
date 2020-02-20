package com.algorithm.btree;

import org.junit.Assert;
import org.junit.Test;

import static com.algorithm.btree.TreeNode.setSubTree;

/*
 * 面试题18：树的子结构(递归)
 * 判断二叉树B是不是二叉树A的子树.
 * 思路：两步：1，递归调用hasSubtree先遍历A中有没有结点的值和B的根结点相同，如果有，调用doesTree1HaveTree2做第二步判断。2，判断AB结构是否相同，即递归判断左右结点。
 */
public class IsSubTree {
    public static boolean doesTree1HasTree2(TreeNode rootA, TreeNode rootB) {
        // 注意if顺序
        if (rootB == null) {
            return true;
        }

        if (rootA == null) {
            return false;
        }

        if (rootA.val != rootB.val) {
            return false;
        }

        return doesTree1HasTree2(rootA.left, rootB.left)
                && doesTree1HasTree2(rootA.right, rootB.right);
    }

    public static boolean hasSubTree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null) {
            return false;
        }

        boolean result = false;

        if (rootA.val == rootB.val) {
            result = doesTree1HasTree2(rootA, rootB);
        }
        if (!result) {
            result = hasSubTree(rootA.left, rootB);
        }

        if (!result) {
            result = hasSubTree(rootA.right, rootB);
        }

        return result;
    }

    @Test
    public void isSubTree() {
        TreeNode rootA = TreeNode.initTree();

        TreeNode rootB = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        setSubTree(rootB, node4, node5);

        boolean hasSubTree = hasSubTree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertTrue(hasSubTree);

        rootB = new TreeNode(3);
        setSubTree(rootB, node4, node5);
        hasSubTree = hasSubTree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertFalse(hasSubTree);
    }
}
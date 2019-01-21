package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

import static com.algorithm.二叉树.BiTreeNode.setSubTree;

/*
 * 面试题18：树的子结构(递归)
 * 判断二叉树B是不是二叉树A的子树.
 * 思路：两步：1，递归调用hasSubtree先遍历A中有没有结点的值和B的根结点相同，如果有，调用doesTree1HaveTree2做第二步判断。2，判断AB结构是否相同，即递归判断左右结点。
 */
public class IsSubTree {
    public static boolean doesTree1HasTree2(BiTreeNode rootA, BiTreeNode rootB) {
        // 注意if顺序
        if (rootB == null) {
            return true;
        }

        if (rootA == null) {
            return false;
        }

        if (rootA.data != rootB.data) {
            return false;
        }

        return doesTree1HasTree2(rootA.left, rootB.left)
                && doesTree1HasTree2(rootA.right, rootB.right);
    }

    public static boolean hasSubTree(BiTreeNode rootA, BiTreeNode rootB) {
        if (rootA == null || rootB == null) {
            return false;
        }

        boolean result = false;

        if (rootA.data == rootB.data) {
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
        BiTreeNode rootA = BiTreeNode.initTree();

        BiTreeNode rootB = new BiTreeNode(2);
        BiTreeNode node4 = new BiTreeNode(4);
        BiTreeNode node5 = new BiTreeNode(5);
        setSubTree(rootB, node4, node5);

        boolean hasSubTree = hasSubTree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertTrue(hasSubTree);

        rootB = new BiTreeNode(3);
        setSubTree(rootB, node4, node5);
        hasSubTree = hasSubTree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertFalse(hasSubTree);
    }
}
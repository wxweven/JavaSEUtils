package com.algorithm.btree;

import org.junit.Assert;
import org.junit.Test;

import static com.algorithm.btree.TreeNode.setSubTree;

/*
 * 面试题18：树的子结构(递归)
 * 判断二叉树B是不是二叉树A的子树.
 *
 * 思路：
 * 这道题就是 IsSameTree 的变种，从根节点开始，遍历这棵树，能找到 isSameTree 的树，那就是找到了子树
 */
public class IsSubTree {
    public boolean isSubtree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null) {
            return false;
        }

        // 中序遍历，先看根节点开始的树是否相同
        if (isSameTree(rootA, rootB)) {
            return true;
        }

        return isSubtree(rootA.left, rootB) || isSubtree(rootA.right, rootB);
    }

    public boolean isSameTree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }

        if (rootA == null || rootB == null) {
            return false;
        }

        return rootA.val == rootB.val
                && isSameTree(rootA.left, rootB.left)
                && isSameTree(rootA.right, rootB.right);

    }

    @Test
    public void isSubTree() {
        TreeNode rootA = TreeNode.initTree();

        TreeNode rootB = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        setSubTree(rootB, node4, node5);

        boolean hasSubTree = isSubtree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertTrue(hasSubTree);

        rootB = new TreeNode(3);
        setSubTree(rootB, node4, node5);
        hasSubTree = isSubtree(rootA, rootB);
        System.out.println(hasSubTree);
        Assert.assertFalse(hasSubTree);
    }
}
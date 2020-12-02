package com.algorithm.btree;

/*
 * 判断两棵⼆叉树是否完全相同
 */
public class IsSameTree {

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
}
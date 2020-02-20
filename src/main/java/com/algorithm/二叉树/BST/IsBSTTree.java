package com.algorithm.二叉树.BST;

import com.algorithm.二叉树.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 * @date 2018/11/4
 */
public class IsBSTTree {
    /**
     * 判断二叉树是否为BST
     */
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min)
                || (max != null && root.val >= max)) {
            return false;
        }

        return isBST(root.left, min, root.val)
                && isBST(root.right, root.val, max);
    }

    @Test
    public void isBSTTree() {
        TreeNode biTreeNode = TreeNode.getBSTTree();
        boolean isBST = isValidBST(biTreeNode);
        System.out.println(isBST);
        Assert.assertTrue(isBST);
    }
}

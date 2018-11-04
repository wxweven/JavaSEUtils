package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 * @date 2018/11/4
 */
public class IsBSTTree {

    public static boolean isBST(BiTreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        int data = root.data;
        if ((data >= min && data <= max)
                && isBST(root.left, min, data)
                && isBST(root.right, data, max)) {
            return true;
        }

        return false;
    }

    public static boolean isBSTTree(BiTreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void isBSTTree() {
        BiTreeNode biTreeNode = BiTreeNode.getBSTTree();
        boolean isBST = isBSTTree(biTreeNode);
        System.out.println(isBST);
        Assert.assertTrue(isBST);

//        BiTreeNode biTreeNode2 = BiTreeNode.initTree();
//        boolean isBST2 = isBSTTree(biTreeNode2);
//        System.out.println(isBST2);
//        Assert.assertFalse(isBST2);
    }
}

package com.algorithm.btree;


/*
 * 面试题19：二叉树的镜像(递归和非递归)
 */
public class MirrorRecursively {
    //递归，先交换结点的左右子结点，然后递归调用左右子结点。
    static void mirrorRecursively(TreeNode tree) {
        if (tree != null) {
            TreeNode temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
            if (tree.left != null) mirrorRecursively(tree.left);
            if (tree.right != null) mirrorRecursively(tree.right);
        }
    }
}

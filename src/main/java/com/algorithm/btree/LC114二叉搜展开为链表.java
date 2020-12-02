package com.algorithm.btree;

public class LC114二叉搜展开为链表 {

    /*
     *
     * 讲解参见：https://www.yuque.com/wxweven/yn3rzz/yt3wzn
     */

    public void convert(TreeNode root) {

        if (root == null) {
            return;
        }

        convert(root.left);
        convert(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}

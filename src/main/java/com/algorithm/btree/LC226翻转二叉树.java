package com.algorithm.btree;

public class LC226翻转二叉树 {

    /*
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 变成
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 讲解参见：https://www.yuque.com/wxweven/yn3rzz/yt3wzn
     */

    public TreeNode inverse(TreeNode root) {

        // 边界条件
        if (root == null) {
            return null;
        }

        // 先序遍历 模板

        // 交换的代码
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        inverse(root.left);
        inverse(root.right);

        return root;
    }
}

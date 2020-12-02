/**
 * @(#)LC230.java, 11月 18, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.algorithm.btree.BST;

import com.algorithm.btree.TreeNode;
import org.junit.Test;

/**
 * @author wxweven
 */
public class LC230BST第K小的数 {

    /**
     * 思路：BST 的中序遍历，就是一个升序数组，遍历到第k个数，就是第k小的数
     */

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        } else {
            System.out.println("" + root.val);
        }

        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }

        if (rank > k) {
            return;
        }

        /*****************/
        traverse(root.right, k);
    }

    @Test
    public void test() {
        TreeNode biTreeNode = TreeNode.getBSTTree();
        int i = kthSmallest(biTreeNode, 2);
        System.out.println(i);
    }

}
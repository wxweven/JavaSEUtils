package com.algorithm.btree.levelorder;

import com.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.algorithm.btree.TreeNode.setSubTree;


/**
 * @author wxweven
 * @date 2018/10/27
 */
public class 二叉树的宽度 {

    /**
     * 利用二叉树的层次遍历，求二叉树的宽度
     *
     * @param root
     * @return
     */
    public static int getBiTreeWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 初始条件，需要把头节点入列
        queue.offer(root);

        TreeNode currentNode;

        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            maxWidth = Math.max(maxWidth, curLevelSize);

            for (int i = 0; i < curLevelSize; i++) {
                currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
            }
        }

        return maxWidth;
    }

    @Test
    public void testGetBiTreeNode() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, node8);
        setSubTree(node6, node9, node10);

        int biTreeWidth = getBiTreeWidth(node1);
        System.out.println(biTreeWidth);
        Assert.assertEquals(4, biTreeWidth);
    }
}

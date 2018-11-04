package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.algorithm.二叉树.BiTreeNode.setSubTree;


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
    public static int getBiTreeWidth(BiTreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<BiTreeNode> queue = new LinkedList<>();
        // 初始条件，需要把头节点入列
        queue.offer(root);

        BiTreeNode currentNode;

        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            if (maxWidth < curLevelSize) {
                maxWidth = curLevelSize;
            }
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
        BiTreeNode node1 = new BiTreeNode(1);
        BiTreeNode node2 = new BiTreeNode(2);
        BiTreeNode node3 = new BiTreeNode(3);
        BiTreeNode node4 = new BiTreeNode(4);
        BiTreeNode node5 = new BiTreeNode(5);
        BiTreeNode node6 = new BiTreeNode(6);
        BiTreeNode node7 = new BiTreeNode(7);
        BiTreeNode node8 = new BiTreeNode(8);
        BiTreeNode node9 = new BiTreeNode(9);
        BiTreeNode node10 = new BiTreeNode(10);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, node8);
        setSubTree(node6, node9, node10);

        int biTreeWidth = getBiTreeWidth(node1);
        System.out.println(biTreeWidth);
        Assert.assertTrue(biTreeWidth == 4);
    }
}

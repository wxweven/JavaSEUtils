package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.algorithm.二叉树.二叉树的深度.setSubTree;

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
    public static int getBiTreeWidth(BiTree root) {
        if (root == null) {
            return 0;
        }

        Queue<BiTree> queue = new LinkedList<>();
        // 初始条件，需要把头节点入列
        queue.offer(root);

        BiTree currentNode;

        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            if (maxWidth < curLevelSize) {
                maxWidth = curLevelSize;
            }
            for (int i = 0; i < curLevelSize; i++) {
                currentNode = queue.poll();
                if (currentNode.getLeftChild() != null) {
                    queue.offer(currentNode.getLeftChild());
                }

                if (currentNode.getRightChild() != null) {
                    queue.offer(currentNode.getRightChild());
                }
            }
        }

        return maxWidth;
    }

    @Test
    public void testGetBiTreeNode() {
        BiTree node1 = new BiTree(1);
        BiTree node2 = new BiTree(2);
        BiTree node3 = new BiTree(3);
        BiTree node4 = new BiTree(4);
        BiTree node5 = new BiTree(5);
        BiTree node6 = new BiTree(6);
        BiTree node7 = new BiTree(7);
        BiTree node8 = new BiTree(8);
        BiTree node9 = new BiTree(9);
        BiTree node10 = new BiTree(10);

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

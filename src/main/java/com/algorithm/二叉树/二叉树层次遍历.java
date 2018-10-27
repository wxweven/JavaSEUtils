package com.algorithm.二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.algorithm.二叉树.二叉树的深度.setSubTree;

/**
 * @author wxweven
 * @date 2018/10/27
 */
public class 二叉树层次遍历 {

    public static void travelByLevel(BiTree root) {
        if (root == null) {
            return;
        }

        Queue<BiTree> queue = new LinkedList<>();
        // 初始条件，需要把头节点入列
        queue.offer(root);

        BiTree currentNode;

        while (!queue.isEmpty()) {
            /**
             * 每一次循环，队列里装的都是当前层的元素，队列的长度是这一层的节点的个数
             * 当遍历完当前层以后，队列里元素全是下一层的元素，
             */
            int curLevelSize = queue.size();

            /**
             * 循环出列当前层的节点，当每个节点出列时，如果存在左右子节点，就需要把左右子节点先后入列
             * 由于上面已经记录了当前层的个数，所以自然新加入的左右子节点，会在下一个while循环遍历
             */
            for (int i = 0; i < curLevelSize; i++) {
                // 将队列里面的节点出列
                currentNode = queue.poll();
                System.out.print(currentNode.getData() + " ");

                // 关键点：将当前节点出列后，需要先后把左孩子、右孩子入列，可以自己画一下，刚好就是层次遍历
                if (currentNode.getLeftChild() != null) {
                    queue.offer(currentNode.getLeftChild());
                }

                if (currentNode.getRightChild() != null) {
                    queue.offer(currentNode.getRightChild());
                }
            }
        }
    }

    @Test
    public void testTravelByLevel() {
        BiTree node1 = new BiTree(1);
        BiTree node2 = new BiTree(2);
        BiTree node3 = new BiTree(3);
        BiTree node4 = new BiTree(4);
        BiTree node5 = new BiTree(5);
        BiTree node6 = new BiTree(6);
        BiTree node7 = new BiTree(7);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, null);

        travelByLevel(node1);
    }
}

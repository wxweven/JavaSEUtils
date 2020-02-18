package com.algorithm.二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wxweven
 * @date 2018/10/27
 */
public class 二叉树层次遍历 {

    public static void travelByLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 初始条件，需要把头节点入列
        queue.offer(root);

        TreeNode currentNode;

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
                System.out.print(currentNode.val + " ");

                // 关键点：将当前节点出列后，需要先后把左孩子、右孩子入列，可以自己画一下，刚好就是层次遍历
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }

    /**
     * 按层次ZigZig打印二叉树
     *
     * @param root
     */
    public static void travelByLevelS(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = true;

        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            if (flag) {
                printList(list);
                flag = false;
            } else {
                printReverseList(list);
                flag = true;
            }
        }
    }

    private static void printReverseList(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    @Test
    public void testTravelByLevel() {
        TreeNode root = TreeNode.initTree();

        travelByLevel(root);
        System.out.println();
        travelByLevelS(root);
    }
}

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
public class 二叉树的深度 {
    /**
     * 递归求解树的深度
     *
     * @param root 根节点
     * @return
     */
    public static int getDeep(BiTreeNode root) {
        if (root == null) {
            return 0;
        }

        int lchilddeep = getDeep(root.left);//求左子树的深度
        int rchilddeep = getDeep(root.right);//求右子树的深度

        // 左子树和右子树深度较大的那个加一等于整个树的深度
        return Math.max(lchilddeep, rchilddeep) + 1;
    }

    /**
     * 求树的深度，非递归实现
     * 利用层次遍历
     *
     * @param root 根节点
     * @return
     */
    public int getDeep2(BiTreeNode root) {
        if (root == null) {
            return 0;
        }

        BiTreeNode current;
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            //每遍历完一层depth+1
            depth++;
        }

        return depth;
    }

    @Test
    public void getDepthTest() {
        BiTreeNode node1 = new BiTreeNode(1);
        BiTreeNode node2 = new BiTreeNode(2);
        BiTreeNode node3 = new BiTreeNode(3);
        BiTreeNode node4 = new BiTreeNode(4);
        BiTreeNode node5 = new BiTreeNode(5);
        BiTreeNode node6 = new BiTreeNode(6);
        BiTreeNode node7 = new BiTreeNode(7);
        BiTreeNode node8 = new BiTreeNode(8);
        BiTreeNode node9 = new BiTreeNode(9);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, node8);
        setSubTree(node6, node9, null);

        int biTreeDepth = getDeep(node1);
        int biTreeDepth2 = getDeep2(node1);
        System.out.println("树的深度：" + biTreeDepth);
        System.out.println("树的深度：" + biTreeDepth2);
        Assert.assertTrue(biTreeDepth == 4);
        Assert.assertTrue(biTreeDepth2 == 4);

    }

}

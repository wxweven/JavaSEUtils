package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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
    public static int getDeep(BiTree root) {
        if (root == null) {
            return 0;
        }

        int lchilddeep = getDeep(root.getLeftChild());//求左子树的深度
        int rchilddeep = getDeep(root.getRightChild());//求右子树的深度

        // 左子树和右子树深度较大的那个加一等于整个树的深度
        return lchilddeep > rchilddeep ? lchilddeep + 1 : rchilddeep + 1;
    }

    /**
     * 求树的深度，非递归实现
     *
     * @param root 根节点
     * @return
     */
    public int getDeep2(BiTree root) {
        if (root == null) {
            return 0;
        }

        BiTree current;
        Queue<BiTree> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                current = queue.poll();
                if (current.getLeftChild() != null) {
                    queue.add(current.getLeftChild());
                }
                if (current.getRightChild() != null) {
                    queue.add(current.getRightChild());
                }
            }

            //每遍历完一层depth+1
            depth++;
        }

        return depth;
    }


    public static void setSubTree(BiTree root, BiTree lChild, BiTree rChild) {
        if (root == null) {
            return;
        }

        root.setLeftChild(lChild);
        root.setRightChild(rChild);
    }

    @Test
    public void getDepthTest() {
        BiTree node1 = new BiTree(1);
        BiTree node2 = new BiTree(2);
        BiTree node3 = new BiTree(3);
        BiTree node4 = new BiTree(4);
        BiTree node5 = new BiTree(5);
        BiTree node6 = new BiTree(6);
        BiTree node7 = new BiTree(7);
        BiTree node8 = new BiTree(8);
        BiTree node9 = new BiTree(9);

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

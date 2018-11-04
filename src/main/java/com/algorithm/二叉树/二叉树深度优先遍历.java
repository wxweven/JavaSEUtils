package com.algorithm.二叉树;

import org.junit.Test;

import java.util.Stack;

public class 二叉树深度优先遍历 {

    @Test
    public void testDepthOrderTraversal() {
        BiTreeNode root = BiTreeNode.initTree();
        depthOrderTraversal(root);
    }

    @Test
    public void testPreOrderTraverse1() {
        BiTreeNode root = BiTreeNode.initTree();
        preOrderTraverse1(root);
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(BiTreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BiTreeNode node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        System.out.print("\n");
    }

    public void preOrderTraverse1(BiTreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

}
package com.algorithm.二叉树;

import static com.algorithm.二叉树.二叉树的深度.setSubTree;

public class BiTreeNode {
    public int data;
    public BiTreeNode leftChild;
    public BiTreeNode rightChild;

    public BiTreeNode(int data) {
        this.data = data;
    }

    public BiTreeNode(int data, BiTreeNode leftChild, BiTreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static BiTreeNode initTree() {
        BiTreeNode node1 = new BiTreeNode(1);
        BiTreeNode node2 = new BiTreeNode(2);
        BiTreeNode node3 = new BiTreeNode(0);
        BiTreeNode node4 = new BiTreeNode(4);
        BiTreeNode node5 = new BiTreeNode(5);
        BiTreeNode node6 = new BiTreeNode(6);
        BiTreeNode node7 = new BiTreeNode(7);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, null);

        return node1;
    }

    public static BiTreeNode getBSTTree() {
        BiTreeNode node1 = new BiTreeNode(12);
        BiTreeNode node2 = new BiTreeNode(5);
        BiTreeNode node3 = new BiTreeNode(15);
        BiTreeNode node4 = new BiTreeNode(3);
        BiTreeNode node5 = new BiTreeNode(7);
        BiTreeNode node6 = new BiTreeNode(13);
        BiTreeNode node7 = new BiTreeNode(17);
        BiTreeNode node8 = new BiTreeNode(1);
        BiTreeNode node9 = new BiTreeNode(9);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, node6, node7);
        setSubTree(node4, node8, null);
        setSubTree(node5, null, node9);

        return node1;
    }

    public static BiTreeNode findMinNode(BiTreeNode root) {
        if(root == null){
            return null;
        }

        if(root.leftChild != null){
            return findMinNode(root.leftChild);
        }

        return root;
    }

    public int getData() {
        return data;
    }

    public BiTreeNode setData(int data) {
        this.data = data;
        return this;
    }

    public BiTreeNode getLeftChild() {
        return leftChild;
    }

    public BiTreeNode setLeftChild(BiTreeNode leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BiTreeNode getRightChild() {
        return rightChild;
    }

    public BiTreeNode setRightChild(BiTreeNode rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
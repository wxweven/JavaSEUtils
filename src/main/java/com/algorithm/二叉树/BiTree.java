package com.algorithm.二叉树;

public class BiTree {
    private int data;
    private BiTree leftChild;
    private BiTree rightChild;

    public BiTree(int data) {
        this.data = data;
    }

    public BiTree(int data, BiTree leftChild, BiTree rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public BiTree setData(int data) {
        this.data = data;
        return this;
    }

    public BiTree getLeftChild() {
        return leftChild;
    }

    public BiTree setLeftChild(BiTree leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BiTree getRightChild() {
        return rightChild;
    }

    public BiTree setRightChild(BiTree rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
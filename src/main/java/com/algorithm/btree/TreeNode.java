package com.algorithm.btree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.val = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, null);

        return node1;
    }

    public static TreeNode getBSTTree() {
        TreeNode node1 = new TreeNode(12);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(17);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(9);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, node6, node7);
        setSubTree(node4, node8, null);
        setSubTree(node5, null, node9);
        setSubTree(node9, null, node10);

        return node1;
    }

    public static void setSubTree(TreeNode root, TreeNode lChild, TreeNode rChild) {
        if (root == null) {
            return;
        }

        root.left = lChild;
        root.right = rChild;
    }

    public static TreeNode findMinNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public int getVal() {
        return val;
    }

    public TreeNode setVal(int val) {
        this.val = val;
        return this;
    }
}
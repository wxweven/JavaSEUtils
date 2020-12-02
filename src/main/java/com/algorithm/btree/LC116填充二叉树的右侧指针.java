package com.algorithm.btree;

public class LC116填充二叉树的右侧指针 {

    /*
     * 将二叉树的每一层，用有指针连起来
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 变成
     *       4
     *    /      \
     *   7    ->  2
     *  / \      /  \
     * 9 ->6 -> 3 -> 1
     *
     * 讲解参见：https://www.yuque.com/wxweven/yn3rzz/yt3wzn
     */

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        connect(root.left, root.right);
        return root;
    }

    public void connect(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }
}

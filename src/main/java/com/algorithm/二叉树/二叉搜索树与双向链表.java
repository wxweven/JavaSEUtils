package com.algorithm.二叉树;

public class 二叉搜索树与双向链表 {
    private BiTreeNode head = null;
    private BiTreeNode tail = null;

    public BiTreeNode Convert(BiTreeNode root) {
        visit(root);
        return head;
    }

    public void visit(BiTreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        createList(root);
        visit(root.right);
    }

    public void createList(BiTreeNode cur) {
        cur.left = tail;//把当前的节点接到链表的尾部
        if (tail != null) {//双向连接
            tail.right = cur;
        } else {
            head = cur;
        }
        tail = cur;//更新尾结点为当前结点，或者说：尾结点后移
    }
}

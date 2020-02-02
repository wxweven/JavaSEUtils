package com.algorithm.二叉树;

/*
 * 面试题27：二叉搜索树与双向链表
 * 将二叉搜索树转换成一个排序的双向链表，要求不能创建新的结点，只能改变树中结点的指向。
 * 思路：搜索树的中序遍历结果是排好序的，如果把它变成排序的双向链表，根结点一定和左子树里最大的结点相连，也一定和右子树最小的结点相连。然后对于左右子树的根结点，递归处理。
 */
public class BST转为双向链表 {
    public static TreeNode convert(TreeNode root) {
        // 这里返回二叉树表示的双向链表
        TreeNode lastNode = null;//指向双向链表尾端(值最大的结点)
        TreeNode headNode = convertNode(root, lastNode);//后边函数返回的是双向链表尾结点，我们需要头结点
        while (headNode != null && headNode.left != null) {
            headNode = headNode.left;
        }
        return headNode;
    }

    public static TreeNode convertNode(TreeNode root, TreeNode lastNode) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        //按照中序遍历左根右的顺序来,左
        if (current.left != null) {
            lastNode = convertNode(current.left, lastNode);
        }
        //根,此时lastNode应是左子树的最大值，与根相连后，根变成了新的lastNode
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        //右
        if (current.right != null) {
            lastNode = convertNode(current.right, lastNode);
        }
        return lastNode;
    }
}
package com.algorithm.btree;

import java.util.*;

public class 二叉树非递归遍历 {
    /**
     * 非递归先序遍历二叉树
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            if (tempNode != null) {
                list.add(tempNode.val);//访问根节点
                stack.push(tempNode.right); //入栈右孩子
                stack.push(tempNode.left);//入栈左孩子
            }
        }

        return list;
    }

    /**
     * 非递归中序遍历二叉树
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    /**
     * 非递归先序遍历二叉树
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}

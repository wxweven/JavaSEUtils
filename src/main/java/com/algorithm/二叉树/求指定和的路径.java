package com.algorithm.二叉树;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wxweven
 * @date 2018/10/29
 */
public class 求指定和的路径 {

    private Stack<Integer> stack = new Stack<>();

    @Test
    public void testFindPath() {
        TreeNode root = TreeNode.initTree();
        boolean path = findPath(root, 7);
        if (path) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                System.out.print(stack.pop() + " ");
            }
        }
        System.out.println();
        System.out.println(path);
    }

    public boolean findPath(TreeNode root, int n) {
        if (root == null || root.getVal() > n) {
            return false;
        }

        int data = root.getVal();
        if (data == n) {
            stack.push(data);
            return true;
        }

        int newValue = n - data;
        boolean left = findPath(root.left, newValue);
        boolean result = left || findPath(root.right, newValue);
        if (result) {
            stack.push(data);
        }

        return result;
    }
}

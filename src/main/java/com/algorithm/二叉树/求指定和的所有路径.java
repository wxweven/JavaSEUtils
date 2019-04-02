package com.algorithm.二叉树;

import java.util.Stack;

/*
 * 面试题25：二叉树中和为某一值的路径
 * 输入一个二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，路径为从根结点一直到叶结点。
 * 思路：四步，1，既然是先输出根结点，那么肯定是先序遍历，把结点添加到输出路径中并累加其值，2，如果访问到的结点是叶结点并且值之和满足条件，则打印路径，3，如果当前结点不是叶结点，就继续递归访问其子结点。
 * 4，当前结点访问结束后，递归函数自动回到其父结点，所以在函数退出前要删掉路径上的该结点并减去其值，保证返回父结点时的路径是从根结点到父结点。可以看出保存路径的数据结构是后进先出的栈。
 */
public class 求指定和的所有路径 {
    public static void findPath(BiTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        Stack<Integer> path = new Stack<>();
        findPath2(root, expectedSum, path);
    }

    public static void findPath2(BiTreeNode root, int expectedSum, Stack<Integer> path) {
        //第一步，把结点加入路径，累加和
        path.push(root.data);

        //第二步，如果结点是叶结点并满足值相等的条件，打印路径
        boolean isLeaf = (root.left == null && root.right == null);
        if (isLeaf && getCurrentSum(path) == expectedSum) {
            System.out.println("A path is found:" + path);
        }

        //第三步，如果结点不是叶结点，递归访问子结点
        if (root.left != null) {
            findPath2(root.left, expectedSum, path);
        }
        if (root.right != null) {
            findPath2(root.right, expectedSum, path);
        }

        //第四步，结点是叶结点，但是值不相等，函数退出到其父结点，在路径中删去这个结点
        path.pop();
    }

    private static int getCurrentSum(Stack<Integer> stack) {
        return stack.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
    }


    public static void main(String[] args) {
        BiTreeNode a = new BiTreeNode(10);
        BiTreeNode b = new BiTreeNode(5);
        BiTreeNode c = new BiTreeNode(12);
        BiTreeNode d = new BiTreeNode(4);
        BiTreeNode e = new BiTreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        findPath(a, 22);
    }
}

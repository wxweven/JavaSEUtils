package com.algorithm.二叉树;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
 * 面试题24：二叉搜索树的后序遍历序列(递归)
 * 输入一个数组，判断数组是不是二叉搜索树的后序遍历结果。
 * 思路：注意是搜索树，即左孩子<根<右孩子，后序序列的最后一个数是根，前边比根小的是左子树，比根大的是右子树，然后对左右子树递归。
 * 相关题目：后序变成前序也是这个思路，树的遍历关键都是先找根结点。
 */
public class 二叉搜索树后序遍历校验 {
    public static boolean verifySequenceOfBST(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return false;
        }
        int root = arr[arr.length - 1];//后序的最后一个数是根
        int i = 0;//分割数组为左右子树,是右子树开始位置的下标
        for (; i < arr.length - 1; i++) {
            // 第一个大于根节点的位置，就是右子树的起点
            if (arr[i] > root) {
                break;
            }
        }

        // 右子树开始位置的下标
        int j = i;
        for (; j < arr.length - 1; j++) {
            // 如果在右子树中找到小于根节点的值，说明不是
            if (arr[j] < root) {
                return false;
            }
        }

        // 递归判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(Arrays.copyOfRange(arr, 0, i));
        }

        // 递归判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < arr.length - 1) {
            // 记得去掉最后一个根结点
            right = verifySequenceOfBST(Arrays.copyOfRange(arr, i, arr.length - 1));
        }

        return left && right;
    }

    public boolean isBST(int[] seq, int start, int end){
        if(start >= end){
            return true;
        }
        int inx=seq[end], m=start;

        //找到分界点
        for(int i=end-1; i>=start; i--){
            if(seq[i]<inx){
                m = i;
                break;
            }
            if(i == start){
                m = -1;
            }
        }
        //分界点前的数据都小于根节点
        for(int i=start; i<=m; i++){
            if(seq[i] > inx){
                return false;
            }
        }
        //分界点后的数据都大于根节点
        for(int i=m+1; i<end; i++){
            if(seq[i] < inx){
                return false;
            }
        }
        //递归判断根节点的左右子树
        return isBST(seq, start, m)&&isBST(seq, m+1, end-1);
    }

    @Test
    public void test() {
        int[] a = {5, 7, 6, 9, 11, 10, 8};
        int[] b = {7, 4, 5, 6};
        int[] c = {7, 8, 10, 6};
        int[] d = {7, 8, 10};
        boolean result = verifySequenceOfBST(a);
        System.out.println(result);
        Assert.assertTrue(result);

        boolean result2 = verifySequenceOfBST(b);
        System.out.println(result2);
        Assert.assertFalse(result2);


        result =isBST(a, 0, a.length-1);
        System.out.println(result);
        Assert.assertTrue(result);

        result =isBST(b, 0, b.length-1);
        System.out.println(result);
        Assert.assertFalse(result);

        result =isBST(c, 0, c.length-1);
        System.out.println(result);
        Assert.assertTrue(result);

        result =isBST(d, 0, d.length-1);
        System.out.println(result);
        Assert.assertTrue(result);
    }
}

package com.algorithm.btree.BST;

import com.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * 面试题27：二叉搜索树与双向链表
 * 答案：https://nightxlt.github.io/2019/02/23/%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E8%BD%AC%E6%8D%A2%E5%8F%8C%E5%90%91%E9%93%BE%E8%A1%A8/
 * 将二叉搜索树转换成一个排序的双向链表，要求不能创建新的结点，只能改变树中结点的指向。
 * 思路：搜索树的中序遍历结果是排好序的，如果把它变成排序的双向链表，
 * 根结点一定和左子树里最大的结点相连，也一定和右子树最小的结点相连。然后对于左右子树的根结点，递归处理。
 */
public class BST转为双向链表 {

    public static TreeNode lastNode = null;

    public static TreeNode convert(TreeNode root) {
        // 这里返回二叉树表示的双向链表
        convertNode(root);

        root = lastNode;

        // 一直向左，找到第一个节点
        while (root != null && root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void convertNode(TreeNode root) {
        if (root == null) {
            return;
        }

        // 按照中序遍历『左根右』的顺序来，先处理左节点
        if (root.left != null) {
            convertNode(root.left);
        }

        // 处理根节点，此时lastNode应是左子树的最大值，与根相连后，根变成了新的lastNode
        root.left = lastNode;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;

        // 处理右节点
        if (root.right != null) {
            convertNode(root.right);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode head = convert(root);

        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.right;
        }

        Assert.assertEquals(3, res.size());
        Assert.assertEquals(1, (int) res.get(0));
        Assert.assertEquals(2, (int) res.get(1));
        Assert.assertEquals(3, (int) res.get(2));

        System.out.println(res);
    }
}
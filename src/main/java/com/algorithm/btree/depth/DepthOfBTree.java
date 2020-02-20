package com.algorithm.btree.depth;

import com.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.algorithm.btree.TreeNode.setSubTree;

/**
 * @author wxweven
 * @date 2018/10/27
 */
public class DepthOfBTree {
    /**
     * 递归求解树的深度
     *
     * @param root 根节点
     * @return
     */
    public static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lchilddeep = getDeep(root.left);//求左子树的深度
        int rchilddeep = getDeep(root.right);//求右子树的深度

        // 左子树和右子树深度较大的那个加一等于整个树的深度
        return Math.max(lchilddeep, rchilddeep) + 1;
    }

    /**
     * 求树的深度，非递归实现
     * 利用层次遍历
     *
     * @param root 根节点
     * @return
     */
    public int getDeep2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            //每遍历完一层depth+1
            depth++;
        }

        return depth;
    }

    @Test
    public void getDepthTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        setSubTree(node1, node2, node3);
        setSubTree(node2, node4, node5);
        setSubTree(node3, null, node6);
        setSubTree(node5, node7, node8);
        setSubTree(node6, node9, null);

        int biTreeDepth = getDeep(node1);
        int biTreeDepth2 = getDeep2(node1);
        System.out.println("树的深度：" + biTreeDepth);
        System.out.println("树的深度：" + biTreeDepth2);
        Assert.assertEquals(4, biTreeDepth);
        Assert.assertEquals(4, biTreeDepth2);

    }
}

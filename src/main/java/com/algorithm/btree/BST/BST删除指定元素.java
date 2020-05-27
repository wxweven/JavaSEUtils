package com.algorithm.btree.BST;

import com.algorithm.btree.TreeNode;
import org.junit.Test;

import static com.algorithm.btree.levelorder.二叉树层次遍历.travelByLevel;


/**
 * @author wxweven
 * @date 2018/11/1
 */
public class BST删除指定元素 {
    public static TreeNode deleteData(TreeNode root, int data) {

        // 如果根节点为null，直接返回null
        if (root == null) {
            return null;
        }

        /*
         * 如果要删除的元素比当前节点值小，根据BST的特点，那要删除的元素肯定在当前节点的左子树里
         * 所以需要在左子树里面去删除，注意，这里的删除左子树，返回的是删除后的左子树的根节点，
         * 需要重新调节当前节点的左孩子
         */
        if (data < root.getVal()) {
            // 递归删除左子树
            // 需要将当前节点的左孩子指向（删除后段左子树的根）
            root.left = deleteData(root.left, data);
        } else if (data > root.getVal()) {
            // 同理，递归删除右子树
            root.right = deleteData(root.right, data);
        } else {
            /*
             * 要删除当前节点，有2种情况
             */

            /*
             * case1: 当前节点节点只有一个孩子，
             * 那么可以删除当前节点，并且让当前节点的父节点指向自己的孩子。
             * 分为两种情况：
             *      没有左孩子，那么让父节点指向右孩子
             *      没有右孩子，那么让父节点指向左孩子
             */
            if (root.left == null) {
                // case2: 当前节点只有一个孩子
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            /*
             * case3: 当前节点节点有两个孩子，
             * 从右子树里面找一个最小的，和当前节点的值交换，然后删除右子树中，值最小的那个节点
             * 因为右子树里面最小的节点，肯定没有左孩子（最多只有一个右节点），这就退化为case2或者case1
             * （也可以从左子树里面找最大的，和当前节点交换，然后删除左子树中值最大的那个节点）
             * 之所以从右子树里找最小的和当前节点交换，是为了保持BST的特性
             */
            // 当前节点有两个孩子，右子树找最小的
            TreeNode minNode = TreeNode.findMinNode(root.right);
            // 和当前节点交换
            root.val = minNode.val;

            // 从右子树里面删除最小的，并且让当前节点的右孩子指向删除后的根
            root.right = deleteData(root.right, minNode.val);
        }

        // 最后，返回删除后树的根
        return root;
    }

    @Test
    public void testDeleteData() {
        TreeNode root = TreeNode.getBSTTree();
        travelByLevel(root);

        TreeNode root2 = deleteData(root, 15);
        System.out.println();

        travelByLevel(root2);
    }


}

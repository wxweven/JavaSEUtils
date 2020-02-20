package com.algorithm.btree;

import java.util.*;

public class 二叉树公共父节点 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.offer(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                parent.put(curNode.left, curNode);
                queue.offer(curNode.left);
            }

            if (curNode.right != null) {
                parent.put(curNode.right, curNode);
                queue.offer(curNode.right);
            }
        }

        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {
            // 自己也要加到自己的parent数组中，不然q是p的子节点的时候，就错了
            pParents.add(p);
            p = parent.get(p);
        }

        while (!pParents.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}

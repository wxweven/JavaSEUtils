package com.algorithm.btree.levelorder;

import com.algorithm.btree.TreeNode;

import java.util.*;

public class LeetCode236 {

    /**
     * Lowest Common Ancestor of a Binary Tree
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }

        while (!pAncestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}

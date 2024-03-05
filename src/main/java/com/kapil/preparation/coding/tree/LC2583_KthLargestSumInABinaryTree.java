package com.kapil.preparation.coding.tree;

import java.util.*;

public class LC2583_KthLargestSumInABinaryTree {

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        long sum = 0;
        while (!q.isEmpty()) {
            TreeNode currentNode = q.remove();
            
            if (currentNode == null) {
                if (q.isEmpty()) break;
                levelSums.add(sum);
                sum = 0;
                q.add(null);
            } else {
                sum += currentNode.val;
                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }
        }

        int l = levelSums.size();
        if (l < k)  return -1;

        Collections.sort(levelSums);

        return levelSums.get(l - k);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

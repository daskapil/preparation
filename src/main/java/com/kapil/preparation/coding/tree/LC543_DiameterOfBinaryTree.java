package com.kapil.preparation.coding.tree;

/*
*
https://leetcode.com/problems/diameter-of-binary-tree/description/
*
*/
public class LC543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        // Approach - 1
        int[] res = {0};
        diameterOfBinaryTree(root, res);
        return res[0];

        // Approach - 2
//        return diameterOfTree(root).diameter - 1;
    }

    // Approach - 1
    // The approach involves a recursive depth-first traversal of the binary tree.
    // At each node, calculate the length of the longest path passing through that
    // node (which is the sum of the heights of its left and right subtrees).
    // Keep track of the maximum diameter encountered so far.
    public int diameterOfBinaryTree(TreeNode root, int[] res) {
        if (root == null) return 0;

        // Recursively calculating depth of left and right subtrees
        int left = diameterOfBinaryTree(root.left, res);
        int right = diameterOfBinaryTree(root.right, res);

        // Updating the maximum diameter encountered so far
        res[0] = Math.max(res[0], left + right);

        // Return the depth of the current node
        return Math.max(left, right) + 1;
    }


    // Approach - 2
    TreeInfo diameterOfTree(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo leftTreeInfo = diameterOfTree(root.left);
        TreeInfo rightTreeInfo = diameterOfTree(root.right);
        int treeHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

        int leftDiameter = leftTreeInfo.diameter;
        int rightDiameter = rightTreeInfo.diameter;
        int diameterThrRoot = leftTreeInfo.height + rightTreeInfo.height + 1;
        int treeDiameter = Math.max(diameterThrRoot, Math.max(leftDiameter, rightDiameter));

        return new TreeInfo(treeHeight, treeDiameter);
    }

    class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
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

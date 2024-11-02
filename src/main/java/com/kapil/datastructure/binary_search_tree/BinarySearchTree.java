package com.kapil.datastructure.binary_search_tree;

import lombok.extern.slf4j.Slf4j;

/*
 * Binary Search Tree (BST) is a binary tree with following properties:
 *   - Left subtree node < root
 *   - Right subtree node > root
 *   - Left & right subtrees are also BST with no duplicate
 *   - By default - no duplicate.  with duplicate is a special case
 *   - Inorder Traversal (LS --> root --> RS) of BST gives an increasing sorted sequence
 *   - Time Complexity: O(H) where H is height of tree. In case of Balanced Tree, H is log(n) where n is no. of nodes
 * */
@Slf4j
public class BinarySearchTree {

    //Insert BST Nodes
    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // O(H)
    public static boolean search(Node root, int key) {
        if (root == null) return false;

        if (key == root.data) {
            return true;
        } else if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // For deletion of a node, there may be 3 possible scenarios arrive:
    // Case - 1: No child (Leaf Node) - Delete node and return null to parent
    // Case - 2: One child - Delete node and replace with child node of deleted node
    // Case - 3: Two child -
    //      Step - 1: Replace value with inorder successor
    //      Step - 2: Delete the node of inorder successor.
    // Inorder successor: The inorder successor is the next higher value in the tree.
    // It will always have 0 child or 1 right child. The deletion inorder successor will follow Case - 1 or Case - 2.
    // How to find inorder successor? - In BST, inorder successor will be the left most node in right subtree.
    public static Node delete(Node root, int value) {
        // First - search the Node to be deleted
        if (value < root.data) {
            return delete(root.left, value);
        } else if (value > root.data) {
            return delete(root.right, value);
        } else { // value == root.data, found the node to be deleted
            // Case - 1: No Child (Leaf Node)
            if (root.left == null && root.right == null) return null;

            // Case - 2: One Child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case - 3: Two Child
            // find the Inorder Successor
            Node inorderSuccessor = findInorderSuccessor(root.right);
            // Replace the value in node which needs to deleted
            root.data = inorderSuccessor.data;
            // Delete inorder successor node from right subtree
            root.right = delete(root.right, inorderSuccessor.data);
        }

        return root;
    }

    private static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    //    Inorder Traversal (LS --> root --> RS) of BST gives an increasing sorted sequence
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Print in Range. ex: x = 6 && y = 10
    // Scenario: 1: x <= root <= y --> values lay on both left and right subtrees
    // Scenario: 2: x >= root --> values lay on both left and right subtrees
    public static void printInRange(Node root, int x, int y) {
        if (root == null) return;

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        } else if (root.data >=  y) {
            printInRange(root.left, x, y);
        }else {
            printInRange(root.right, x, y);
        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }

        inorder(root);
        log.info("");
        log.info("search({}): {}", 10, search(root, 10));

        // deleting node
//        inorder(delete(root, 5));

        //print in range
        printInRange(root, 6, 10);
    }
}

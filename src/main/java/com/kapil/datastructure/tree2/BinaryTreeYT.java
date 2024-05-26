package com.kapil.datastructure.tree2;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class BinaryTreeYT {

    // 1. Preorder Traversal
    // root --> left subtree --> right subtree
    // O(n)
    public static void preorder(Node root) {
        if (root == null) return;

        log.info("Preorder = {}", root.data);
        preorder(root.left);
        preorder(root.right);
    }


    // 2. Inorder Traversal
    // left subtree --> root --> right subtree
    // O(n)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        log.info("inorder = {}", root.data);
        inorder(root.right);
    }

    // 3. Postorder Traversal
    // left subtree --> right subtree --> root
    // O(n)
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        log.info("postorder = {}", root.data);
    }

    // 4. Level order Traversal
    // traversing level wise - Breadth First Search (BFS)
    // O(n)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();

            if (currentNode == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    queue.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
    }

    // O(n)
    public static int countOfNodes(Node root) {
        if (root == null) return 0;

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // O(n)
    public static int sumOfNodes(Node root) {
        if (root == null) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // O(n)
    public static int heightOfTree(Node root) {
        if (root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Diameter of Tree
    // longest path in a tree
    // Approach 1 - calculating height and diameter separately
    // Time complexity - O(n^2)
    public static int diameterOfTree(Node root) {
        if (root == null) return 0;

        int diameterThroughRoot = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);

        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    // Diameter of Tree
    // longest path in a tree
    // Approach 2 - calculating height and diameter at sametime reducing time complexity to O(n)
    // Time complexity - O(n)
    public static TreeInfo diameterOfTreeOptimized(Node root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo leftTreeInfo = diameterOfTreeOptimized(root.left);
        TreeInfo rightTreeInfo = diameterOfTreeOptimized(root.right);
        int treeHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

        int leftDiameter = leftTreeInfo.diameter;
        int rightDiameter = rightTreeInfo.diameter;
        int diameterThroughRoot =  leftTreeInfo.height + rightTreeInfo.height + 1;
        int treeDiameter = Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));

        return new TreeInfo(treeHeight, treeDiameter);
    }

    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) return null;

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void main(String[] args) {
        //Preorder sequence
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = BinaryTree.buildTree(nodes);
//        log.info("root.data = {}", root.data);
//        preorder(root); // 1,2,4,5,3,6
//        inorder(root); // 4,2,5,1,3
//        postorder(root); // 4,5,2,6,3,1
//        levelOrder(root); // 1\n 2 3\n 4 5 6

//        log.info("countOfNode(root) = {}", countOfNodes(root)); //6
//        log.info("sumOfNode(root) = {}", sumOfNodes(root)); //21
//        log.info("heightOfTree(root) = {}", heightOfTree(root)); //3
//        log.info("diameterOfTree(root) = {}", diameterOfTree(root)); //5
        log.info("diameterOfTreeOptimized(root) = {}", diameterOfTreeOptimized(root).diameter); //5
    }
}

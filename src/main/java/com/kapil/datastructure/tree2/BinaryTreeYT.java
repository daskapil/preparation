package com.kapil.datastructure.tree2;

import com.sun.source.tree.Tree;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Slf4j
public class BinaryTreeYT {
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
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder Traversal
    // root --> left subtree --> right subtree
    // O(n)
    public static void preorder(Node root) {
        if (root == null) return;

        log.info("Preorder: {}", root.data);
        preorder(root.left);
        preorder(root.right);
    }


    // Inorder Traversal
    // left subtree --> root --> right subtree
    // O(n)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        log.info("Inorder: {}", root.data);
        inorder(root.right);
    }

    // Postorder Traversal
    // left subtree --> right subtree --> root
    // O(n)
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        log.info("Postorder: {}", root.data);
    }

    // Postorder Traversal
    // left subtree --> right subtree --> root
    // O(n)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

    // O(n)
    public static int countOfNode(Node root) {
        if (root == null) return 0;

        int leftNodes = countOfNode(root.left);
        int rightNodes = countOfNode(root.right);

        return leftNodes + rightNodes + 1;
    }

    // O(n)
    public static int sumOfNode(Node root) {
        if (root == null) return 0;

        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);

        return leftSum + rightSum + root.data;
    }

    // O(n)
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //O(n^2)
    public static int diameterOfTree(Node root) {
        if (root == null) return 0;

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        int diameterThroughRoot = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }


    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    //O(n)
    public static TreeInfo diameterOfTree2(Node root) {
        if (root == null) return new TreeInfo(0,0);

        TreeInfo left = diameterOfTree2(root.left);
        TreeInfo right = diameterOfTree2(root.right);
        int treeHeight = Math.max(left.height, right.height) + 1 ;

        int leftDiameter = left.diameter;
        int rightDiameter = right.diameter;
        int diameterThroughRoot =  left.height + right.height + 1;
        int treeDiameter = Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));

        return new TreeInfo(treeHeight, treeDiameter);
    }

    public static void main(String[] args) {
        //Preorder sequence
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = BinaryTree.buildTree(nodes);
//        preorder(root); // 1,2,4,5,3,6
//        inorder(root); // 4,2,5,1,3,6
//        postorder(root); // 4,5,2,6,3,1
//        levelOrder(root); // 1\n 2 3\n 4 5 6

        System.out.println(countOfNode(root)); //6
        System.out.println(sumOfNode(root)); //21
        System.out.println(heightOfTree(root)); //3
        System.out.println(diameterOfTree(root)); //5
        System.out.println(diameterOfTree2(root).diameter); //5
    }
}

package com.kapil.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BinaryTree {

    private Node root;
    private Node left;
    private Node right;

    public void addFirst (char value) {
        root = new Node(value);
    }


    public Node buildBinaryTree() {
        Node a = new Node ('a');
        Node b = new Node ('b');
        Node c = new Node ('c');
        Node d = new Node ('d');
        Node e = new Node ('e');
        Node f = new Node ('f');

        a.right = b;
        a.left = c;
        b.right = d;
        b.left = e;
        c.left = f;

        return a;
    }

    public void depthFirstValues(Node root) {
        Deque<Node> stack = new ArrayDeque<>(List.of(root));
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);

            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
    }

    private class Node {
        char value;
        Node left;
        Node right;

        public Node (char value) {
            this(value, null, null);
        }
        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
package com.kapil.datastructure.tree;

public class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            while (current != null) {
                if (value < current.value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            current = node;
        }
    }

    public void insertRecursion(int value) {
        insertRecursion(value, root);
    }

    private void insertRecursion(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return;
        }

        if (value < node.value) {
            insertRecursion(value, node.left);
        } else {
            insertRecursion(value, node.right);
        }
    }

    public boolean lookup(int value) {
        if (root == null) return false;

        Node current = root;
        while (current != null) {
            if (value == current.value) return true;

            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public boolean lookupRecursion(int value) {
        return lookupRecursion(value, root);
    }

    public boolean lookupRecursion(int value, Node node) {
        if (node == null) return false;

        if (value == node.value) return true;

        if (value < node.value) {
            return lookupRecursion(value, node.left);
        } else {
            return lookupRecursion(value, node.right);
        }
    }

    boolean remove(int value) {
        if(root == null) return false;

        Node current = root;
        Node parent = null;

        while (current != null) {
            if(value < current.value){
                parent = current;
                current = current.left;
            } else if (value > current.value) {
                parent = current;
                current = current.right;
            } else {
                // we have a match, get to work
                //No right node child
                if (current.right == null) {
                    if (parent == null){
                        this.root = current.left;
                    } else {
                        //if parent > current value, make current left child a child of parent
                        if (current.value < parent.value){
                            parent.left = current.left;
                            //if parent < current value, make left child a right child of parent
                        } else if (current.value > parent.value){
                            parent.right = current.left;
                        }
                    }
                    //Option 2: Right child which doesn't have a left child
                } else if (current.right.left == null) {
                    current.right.left = current.left;
                    if (parent == null) {
                        root = current.right;
                    } else {

                        //if parent > current, make right child of the left the parent
                        if(current.value < parent.value) {
                            parent.right = current.right;

                        //if parent < current, make right child a right child of the parent
                        } else if (current.value > parent.value){
                            parent.right = current.right;
                        }
                    }

                    //Option 3: Right child that has a left child
                } else {

                    //find the Right child's left most child
                    Node leftMost = current.right.left;
                    Node leftMostParent = current.right;
                    while (leftMost.left != null) {
                        leftMostParent = leftMost;
                        leftMost = leftMost.left;
                    }

                    //Parent's left subtree is now leftmost's right subtree
                    leftMostParent.left = leftMost.right;
                    leftMost.left = current.left;
                    leftMost.right = current.right;

                    if(parent == null) {
                        root = leftMost;
                    } else {
                        if (current.value < parent.value) {
                            parent.left = leftMost;
                        } else if (current.value > parent.value) {
                            parent.right = leftMost;
                        }
                    }
                }
            }
        }
        return true;
    }

    public Node traverse(Node in, Node out){
        if (in == null) return out;

        Node left = in.left == null ? null : traverse(in.left, out);
        Node right = in.right == null ? null : traverse(in.right, out);
        return new Node(in.value, left, right);
    }

    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this(value, null, null);
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}



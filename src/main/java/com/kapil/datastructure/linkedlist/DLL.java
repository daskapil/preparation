package com.kapil.datastructure.linkedlist;

/*
 * Doublely LinkedList
 * */
public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node last = head;

        if (head == null) {
            insertFirst(value);
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        Node node = new Node(value, null, last);
        last.next = node;
        size++;
    }

    public void insert(int value, int target) {
        Node targetNode = find(target);

        if (targetNode == null) {
            System.out.println("Target node is not found!");
            return;
        }

        Node node = new Node(value, targetNode.next, targetNode);
        targetNode.next = node;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            last = node;
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse:");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

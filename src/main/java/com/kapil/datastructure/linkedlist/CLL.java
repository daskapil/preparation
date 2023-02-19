package com.kapil.datastructure.linkedlist;

import org.w3c.dom.Node;

/*
 * Circular LinkedList
 * */
public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // For circular LinkedList insertFirst and insertLast
    // operations are same operations due to circular nature.
    // tail.next is pointing to head
    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void delete(int value) {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }

        Node node = head;
        do {
            Node n = node.next;
            if(n.value == value){
                node.next= n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}

package com.kapil.preparation.coding.linkedlist;

import org.w3c.dom.Node;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 * Easy
 * */
public class  LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
//        return previous;
        head = previous;
        return head;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversedSublist = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return reversedSublist;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

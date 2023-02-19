package com.kapil.preparation.coding.linkedlist;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Easy
 * */
public class LC876_MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

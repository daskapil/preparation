package com.kapil.preparation.coding.linkedlist;
/*
* https://leetcode.com/problems/remove-duplicates-from-sorted-list/
* Easy
*
* **** Run it from LeetCode for testing. Otherwise, you have to right code
* for inserting element in LinkedList ****
* */
public class LC83_RemoveDuplicatesFromSortedList {
    ListNode head;

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesRecursion(ListNode head) {

        if (head == null || head.next == null) return head;

        if (head.val == head.next.val){
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    // Definition for singly-linked list
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

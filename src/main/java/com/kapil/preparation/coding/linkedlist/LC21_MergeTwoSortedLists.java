package com.kapil.preparation.coding.linkedlist;

/*
 *https://leetcode.com/problems/merge-two-sorted-lists/
 * */
public class LC21_MergeTwoSortedLists {
    /*
     * Time complexity = O(List1_size + List2_size)
     * Space Complexity = O(1)
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

//        if(list1 != null) tail.next = list1;
//        if(list2 != null) tail.next = list2;

        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }

    /*
     * Time complexity = O(List1_size + List2_size)
     * Space Complexity = O(List1_size + List2_size)
     * */
    public ListNode mergeTwoLists_recursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoLists_recursive(list1, list2);

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

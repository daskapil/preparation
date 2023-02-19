package com.kapil.preparation.coding.linkedlist;

/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * */
public class LC142_LinkedListCycleII {

    public ListNode detectCycle_Optimized(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
       int length = lengthOfCycle(head);

       // When no cycle exists
        if( length == 0) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while(length > 0){
            p1 = p1.next;
            length--;
        }

        while(p1 != p2){
           p1 = p1.next;
           p2 = p2.next;
        }

        return p1;
    }

    private int lengthOfCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                int length = 0;
                do{
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }

        return 0;
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

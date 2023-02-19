package com.kapil.preparation.coding.linkedlist;

/*
 * https://leetcode.com/problems/linked-list-cycle/
 * Easy
 * */
public class LC141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        /*boolean hasCycle = false;
        int cycleLength = 0;
        while (fast != null && fast.next != null){

            if(!hasCycle && fast != slow){
                fast = fast.next.next;
                slow= slow.next;
                hasCycle = true;
            }

            if (hasCycle){
                slow= slow.next;
                cycleLength++;
                if(fast == slow){
                    break;
                }
            }

            return cycleLength;
        }*/

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (fast != slow);
                return length;
            }
        }
        return 0;

    }

    public int lengthOfCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                int l = 0;
                do{
                    slow = slow.next;
                    l++;
                } while (fast != slow);
                return l;
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

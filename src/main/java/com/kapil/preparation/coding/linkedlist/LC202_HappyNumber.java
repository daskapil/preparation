package com.kapil.preparation.coding.linkedlist;

/*
 * https://leetcode.com/problems/happy-number/
 * */
public class LC202_HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != 1 && slow != fast);

        return fast == 1;
    }

    private static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }
}

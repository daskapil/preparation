package com.kapil.preparation.coding.math;

/*
 *https://leetcode.com/problems/reverse-integer/
 * */
public class LC7_ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverseInteger(10));
        System.out.println(reverseRecur(103));
    }

    private static int reverseInteger(int i) {
        int reverse = 0;

        while (i != 0) {
            int result = reverse * 10 + i % 10;
            if (result / 10 != reverse) return 0;
            reverse = result;
            i /= 10;
        }

        return reverse;
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    private static int reverseRecur(int n) {
        int digits = (int) Math.log10(n) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        int rem = n % 10;

        if (rem == n) return n;

        return rem * (int) Math.pow(10, digits - 1) + helper(n / 10, digits - 1);
    }
}

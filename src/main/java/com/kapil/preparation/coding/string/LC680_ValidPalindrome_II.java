package com.kapil.preparation.coding.string;

/*
 * https://leetcode.com/problems/valid-palindrome-ii/
 * */
public class LC680_ValidPalindrome_II {

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        if (s.isBlank()) return true;

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }

            l++;
            r--;
        }

        return true;
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}

package com.kapil.preparation.coding.string;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/valid-palindrome/
 * */
public class LC125_Palindrome {
    public static void main(String[] args) {
        String s = "tat tat";
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("isPalindromeStringBuilder(" + s1 + "): " + isPalindromeStringBuilder(s));
        System.out.println("isPalindromeStreamAPI(" + s + "): " + isPalindromeStreamAPI(s));
        System.out.println("isPalindromeWhile(" + s1 + "): " + isPalindromeWhile(s1));
        System.out.println("isPalindromeRecur(" + s1 + "): " + isPalindromeRecur(s1));

    }

    private static boolean isPalindromeStreamAPI(String str) {
        String temp = str.replaceAll("\\s+", "")    ;
        int length = temp.length();
        return IntStream.range(0, length / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(length - i - 1));
    }

    private static boolean isPalindromeStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    private static boolean isPalindromeWhile(String s) {
        String tmp = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        int n = tmp.length();

        if (tmp.isBlank()) {
            return true;
        }

        return IntStream.range(0, n / 2).noneMatch(i -> tmp.charAt(i) != tmp.charAt(n - i - 1));
//        for (int i = 0; i < len / 2; i++) {
//            if (tmp.charAt(i) != tmp.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
    }



    // Recursion
    private static boolean isPalindromeRecur(String s){
        s = s.toLowerCase().replaceAll("[^a-b0-9]+", "");
        if(s.isBlank()) return true;
        return isPalindromeRecur(s, 0, s.length());
    }

    private static boolean isPalindromeRecur(String s, int l, int r){
        if(l >= r) return true;

        if (s.charAt(l) != s.charAt( r - 1)) return false;

        return isPalindromeRecur(s, l + 1,  r -1);
    }
}

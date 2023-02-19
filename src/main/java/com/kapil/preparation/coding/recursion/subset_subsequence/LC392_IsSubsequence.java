package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/is-subsequence/
 * Easy
 * Time complexity: O(min(m, n))
 * Space complexity: O(max(m, n))
 * */
public class LC392_IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        return isSubsequence(s, t, m, n);
    }

    private static boolean isSubsequence(String s, String t, int m, int n) {
        //base case
        if (m == 0) return true;
        if (n == 0) return false;

        // if last chars of two string are matching
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return isSubsequence(s, t, m - 1, n - 1);
        }

        // if last chars of two string are not matching
        return isSubsequence(s, t, m, n - 1);
    }

    public static boolean isSubsequenceIterative(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(i))
                i++;
            j++;
        }
        // If i reaches end of s,that mean we found all characters of s in t,
        // so s1 is subsequence of s2, else not
        return i == m;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}

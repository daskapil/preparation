package com.kapil.preparation.coding.string;

import java.util.Arrays;

/*
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * https://leetcode.com/problems/valid-anagram/
 * */
public class LC242_ValidAnagram {

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println("isAnagram: " + isAnagram("rate", "tear"));
    }
}

package com.kapil.preparation.coding.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-palindrome/
 * Easy
 * */
public class LC409_LongestPalindrome {
    public static int longestPalindrome(String s) {
        int count = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (set.contains(c)) {
               count += 2;
               set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.size()  > 0) {
            count++;
        }

        return count;
    }

    public static int longestPalindrome_2(String s) {
        int[] chars = new int[52];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z' ){
                chars[c - 'a']++;
            } else {
                chars[c - 'A' + 26]++;
            }
        }

        int count = 0;
        for (int i = 0; i < chars.length; i++){
            count += chars[i] / 2;
        }

        count = count * 2;
        System.out.println(count);
        return Math.min(s.length(), count + 1);
    }


    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
//        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome_2("ababababa"));
    }
}

package com.kapil.preparation.coding.string;

/*
 * https://leetcode.com/problems/longest-common-prefix/
 * Easy
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * */
/*
 * Time Complexity: O(n) Worst case: n = number of characters in first String in the array
 * Space Complexity: O(1)
 * */
public class LC14_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = "";
        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            for (String s : strs) {
                if (i == s.length() || first.charAt(i) != s.charAt(i))
                    return prefix;
            }
            prefix += first.charAt(i);
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}

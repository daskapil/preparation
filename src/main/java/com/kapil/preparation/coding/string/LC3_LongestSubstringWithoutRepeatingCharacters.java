package com.kapil.preparation.coding.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int f = 0;
        int l = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

         while (l < s.length()) {
            if (!set.contains(s.charAt(l))) {
                set.add(s.charAt(l));
                l++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(f));
                f++;
            }
        }

        return max;

    }

    /*
     * The basic idea is, keep a hashmap which stores the characters in string as keys and
     * their positions as values, and keep two pointers which define the max substring.
     * move the right pointer to scan through the string , and meanwhile update the hashmap.
     * If the character is already in the hashmap, then move the left pointer to the right of
     * the same character last found. Note that the two pointers can only move forward.
     * */
    public static int lengthOfLongestSubstringMap(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;

        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}



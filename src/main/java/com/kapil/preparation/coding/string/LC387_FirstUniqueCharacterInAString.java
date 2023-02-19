package com.kapil.preparation.coding.string;

import javax.crypto.spec.PSource;
import java.util.*;
import java.util.stream.IntStream;


/*
* https://leetcode.com/problems/first-unique-character-in-a-string/
* Easy
* */
public class LC387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "llleetcode";
        System.out.println(firstUniqChar(s));
    }

    //Optimized
    public static int firstUniqChar(String s) {
        int n = s.length();
        int[] frequency = new int[26];

        for (int i = 0; i < n ; i++){
            int index = s.charAt(i)  - 'a';
            frequency[index]++;
        }
        System.out.println(Arrays.toString(frequency));

        for(int i = 0; i < n; i++){
            if(frequency[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static int firstUniqChar_1(String s) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                charMap.remove(c);
            } else {
                charMap.put(c, i);
                set.add(c);
            }
        }

        return charMap.isEmpty() ? -1 : charMap.entrySet().iterator().next().getValue();
    }
}

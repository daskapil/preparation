package com.kapil.preparation.coding.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/isomorphic-strings/
 * Easy
 * */
public class LC205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            //if cS is seen before in S
            if (map.containsKey(cS)) {
                //Return false if  first occurrence of cS is already mapped to another char
                if (!map.get(cS).equals(cT)) return false;

                // if cS is seen for first time
            } else {
                //Return false if cT value is already mapped to another char in "s"
                if (set.contains(cT)) return false;
                //map cS and cT and mark it as mapped
                map.put(cS, cT);
                set.add(cT);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "badc", t = "baba";
//        char a = 'b';
//        Character A = 'a';
//        System.out.println(A.equals(a));
        System.out.println(isIsomorphic(s, t));
    }
}

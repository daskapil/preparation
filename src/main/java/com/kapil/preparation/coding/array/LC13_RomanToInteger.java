package com.kapil.preparation.coding.array;

import java.util.HashMap;
import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*/
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * https://leetcode.com/problems/roman-to-integer/
 * */
public class LC13_RomanToInteger {
    public static void main(String[] args) {
        System.out.println("romanToInteger: " + romanToInteger2("MCMXCIV"));
    }

    /*
     *
     * Example 4:
     * Input: s = "IV"
     * Output: 4
     *
     * Example 4:
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * */
    private static int romanToInteger(String roman) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            if (i > 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1))) {
                result += map.get(roman.charAt(i)) - 2 * map.get(roman.charAt(i - 1));
            } else {
                result += map.get(roman.charAt(i));
            }
        }

        return result;
    }

    private static int romanToInteger2(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        System.out.println(map);

        int result = 0;
        int length = roman.length();
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                result -= map.get(roman.charAt(i));
            } else {
                result += map.get(roman.charAt(i));
            }
        }

        return result;
    }
}

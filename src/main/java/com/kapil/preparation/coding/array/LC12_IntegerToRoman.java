package com.kapil.preparation.coding.array;

import java.util.*;

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
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it
making four. The same principle applies to the number nine, which is written as IX. There are six instances
where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer numeral, convert it to a roman.
*/
/*
 *
 * Example 1:
 * Input: num = 4
 * Output: "IV"
 *
 * Example 2:
 * Input: num = 1994
 * Output: "MCMXCIV"
 *
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * */
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * https://leetcode.com/problems/integer-to-roman/
 * */
public class LC12_IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("Integer to Roman: " + intToRoman(193));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int quotient = num / entry.getKey();

            if (quotient > 0) {
                result.append(entry.getValue().repeat(quotient));
            }

            num = num % entry.getKey();
            if (num == 0)
                break;
        }

        return result.toString();
    }
}

package com.kapil.preparation.coding;

import java.util.Arrays;

/*
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array
 * in-place with O(1) extra memory.
 * */
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class ReverseStringArray {
    public static void reverseString(char[] array) {
        int forward = 0;
        int reverse = array.length - 1;
        while (forward < reverse) {
            char temp = array[forward];
            array[forward] = array[reverse];
            array[reverse] = temp;
            forward++;
            reverse--;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
//        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] s = {'o', 'l', 'l', 'e', 'h'};
        reverseString(s);
    }
}

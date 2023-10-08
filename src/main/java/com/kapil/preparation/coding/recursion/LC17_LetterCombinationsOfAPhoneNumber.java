package com.kapil.preparation.coding.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * */
public class LC17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(pod("23"));
        System.out.println(letterCombinations("1"));
    }

    // 2 - 9 number pad
    public static List<String> letterCombinations(String digits) {
        return letterCombinations(digits, "");
    }

    public static List<String> letterCombinations(String in, String out) {
        List<String> list = new ArrayList<>();

        if (in.isBlank()) {
            list.add(out);
            return list;
        }

        int digit = in.charAt(0) - '0';

        if (digit <= 1) return list;

        int s = (digit - 2) * 3;
        int e = (digit - 1) * 3;

        if (digit == 7) {
            e += 1;
        }

        if (digit == 8) {
            s += 1;
            e += 1;
        }

        if (digit == 9) {
            s += 1;
            e += 2;
        }

        for (int i = s; i < e; i++) {
            char ch = (char) ('a' + i);
            list.addAll(letterCombinations(in.substring(1), out + ch));
        }

        return list;
    }

    // considering 1 - 9
    public static List<String> pod(String digits) {
        return pod(digits, "");
    }

    private static List<String> pod(String in, String out) {
        List<String> list = new ArrayList<>();

        if (in.isEmpty()) {
            list.add(out);
            return list;
        }
        // e.g '2' ASCII value = 50 && '0' ASCII value = 48
        // Hence '2' - '0' => 50 - 48 = 2
        int digit = in.charAt(0) - '0'; // first digit

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(pod(in.substring(1), out + ch));
        }

        return list;
    }
}

package com.kapil.preparation.coding.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/count-and-say/
 * */
public class LC38_CountAndSay {
    public static String countAndSay(int n) {
        if (n <= 0) return "";

        String ans = "1";
        int l = ans.length();
        while (n > 1) {
            StringBuilder  cur = new StringBuilder();

            for (int i = 0; i < l; i++) {
                int count = 1;
                while (i + 1 < l && ans.charAt(i) == ans.charAt(i + 1)){
                    count++;
                    i++;
                }
                cur.append(count).append(ans.charAt(i));
            }
            ans = cur.toString();
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}

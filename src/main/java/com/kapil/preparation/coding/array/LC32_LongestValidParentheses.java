package com.kapil.preparation.coding.array;

import java.util.Stack;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * */
public class LC32_LongestValidParentheses {
    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public static int longestValidParentheses_BrutForce(String s) {
        int n = s.length();

        if (n < 2) return 0;

        int max = 0;
        int open = 0;
        int close = 0;

        // 0 ---> n
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                max = Math.max(max, (open + close));
            } else if (close > open){
                open = close = 0;
            }
        }

        open = close = 0;
        // n ---> 0
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                max = Math.max(max, (open + close));
            } else if (open > close){
                open = close = 0;
            }
        }

        return max;
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     * */
    public static int longestValidParentheses_WithStack(String s) {
        int n = s.length();

        if (n < 2) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "()())";
        // String s = "(()";
        System.out.println("longestValidParentheses_BrutForce: " + longestValidParentheses_BrutForce(s));
        System.out.println("longestValidParentheses: " + longestValidParentheses_WithStack(s));
    }
}

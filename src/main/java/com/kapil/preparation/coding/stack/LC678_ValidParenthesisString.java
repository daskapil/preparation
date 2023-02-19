package com.kapil.preparation.coding.stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parenthesis-string/
 * */
public class LC678_ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))()"));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> opening = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') opening.push(i);
            if (c == '*') star.push(i);

            if (c == ')') {
                if (!opening.isEmpty()) {
                    opening.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!opening.isEmpty() && !star.isEmpty()) {
            if (opening.pop() > star.pop()) return false;
        }

        return opening.isEmpty();
    }
}

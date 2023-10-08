package com.kapil.preparation.coding.stack;

import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * */
public class
LC20_ValidParentheses {

    public static void main(String[] args) {
        String s = "((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            }
        }

        return stack.isEmpty();
    }
}

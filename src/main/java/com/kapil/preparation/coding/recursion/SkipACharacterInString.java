package com.kapil.preparation.coding.recursion;

public class SkipACharacterInString {

    public static void main(String[] args) {
//        String s = "baccad";
//        char c = 'a';
//        System.out.println(skipAChar(s, c));

        String str = "bappleccappd";
//        String skip = "apple";
//        System.out.println(skipAString(str, skip));

        System.out.println(skipAppNotApple(str));
    }

    private static String skipAChar(String s, char c) {
        StringBuilder input = new StringBuilder(s);
        StringBuilder output = new StringBuilder();
        return skipAChar(input, c, output).toString();
    }

    private static StringBuilder skipAChar(StringBuilder input, char c, StringBuilder output) {
        if (input.length() == 0) return output;

        if (input.charAt(0) != c) {
            output.append(input.charAt(0));
        }

        return skipAChar(input.deleteCharAt(0), c, output);
    }

    private static String skipAChar2(String s, char c) {
        if (s.isEmpty()) return "";

        char ch = s.charAt(0);
        if (ch == c) {
            return skipAChar2(s.substring(1), c);
        } else {
            return ch + skipAChar2(s.substring(1), c);
        }
    }

    private static String skipAString(String in, String skip) {
        if(in.isEmpty()) return "";

        char ch = in.charAt(0);
        if (in.startsWith(skip)) {
            return skipAString(in.substring(skip.length()), skip);
        } else {
            return ch + skipAString(in.substring(1), skip);
        }
    }

    private static String skipAppNotApple(String in) {
        if(in.isEmpty()) return "";

        char ch = in.charAt(0);
        if (in.startsWith("app") && !in.startsWith("apple")) {
            return skipAppNotApple(in.substring(3));
        } else {
            return ch + skipAppNotApple(in.substring(1));
        }
    }

}

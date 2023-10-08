package com.kapil.preparation.coding.string;

public class LC58_LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
//        System.out.println(s.replaceAll("[^a-zA-B0-9 ]", s).trim().split("\\s"));

        String[] words = s.replaceAll("[^a-zA-B0-9 ]", s).trim().split("\\s");

        return words[words.length - 1].length();
    }
}

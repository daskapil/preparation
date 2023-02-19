package com.kapil.preparation.apple;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AppleInterview {
    /*
  Using the characters in the input string, if you can create an English word, return true. The input string will include an unique set of characters. You may use the same character multiple times.
    [Example]
    Input: "ad" or "da"
    Output: true
    Reason: using the chars "a" and "d", you can create the English word "add" or "dad".
*/


    public static void main(String[] args) {
        String s = "ad";
        System.out.println(isEnglishWord(s));
    }

    public static boolean isEnglishWord(String s) {
        Set<String> set = new TreeSet<>(List.of("add", "dad"));

        if (set.contains(s)) return true;

        for (String el : set) {
            if (el.contains(s)) return true;
        }

        return false;
    }

}

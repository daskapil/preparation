package com.kapil.preparation.coding.recursion;

public class LC1910_RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences2(s, part));
    }

    //Option: 1
    public static String removeOccurrences2(String s, String part) {
        return s.contains(part) ? removeOccurrences2(s.replaceFirst(part, ""), part) : s;
    }

    //Option: 2
    public static String removeOccurrences(String s, String part) {
        return removeOccurrences(s, part, 0);
    }

    public static String removeOccurrences(String s, String part, int index) {
        int pl = part.length();
        int sl = s.length();

        if(sl < pl || !s.contains(part) || sl < index) return s;

        if(s.substring(index, index + pl).equals(part)){
            s = s.replaceFirst(part, "");
            index = 0;
        } else {
            index++;
        }
        return removeOccurrences(s, part, index);
    }
}

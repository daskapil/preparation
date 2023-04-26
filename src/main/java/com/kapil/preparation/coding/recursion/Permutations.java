package com.kapil.preparation.coding.recursion;

import java.util.ArrayList;
import java.util.List;

/*
* String
* Recursion
* Permutation
* */
public class Permutations {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permutations(s));
        System.out.println(permutationsCount(s));
    }

    private static List<String> permutations(String in) {
        return permutations2(in, "");
    }

    private static List<String> permutations(String in, String out) {
        List<String> list = new ArrayList<>();

        if(in.isEmpty()){
            list.add(out);
            return list;
        }

        char ch = in.charAt(0);
        for(int i = 0; i <= out.length(); i++) {
            String f = out.substring(0 , i);
            String s = out.substring(i, out.length());
            list.addAll(permutations(in.substring(1), f + ch + s));
        }

        return list;
    }


    private static List<String> permutations2(String in, String out) {
        List<String> list = new ArrayList<>();

        if (in.isEmpty()) {
            list.add(out);
            return list;
        }

        char ch = in.charAt(0);
        for (int i = 0; i <= out.length(); i++) {
            String f = out.substring(0, i);
            String s = out.substring(i);
            list.addAll(permutations2(in.substring(1),f + ch + s));

        }
        return list;
    }

    // Count Permutations
    private static int permutationsCount(String in) {
        return permutationsCount(in, "");
    }

    private static int permutationsCount(String in, String out) {
        int count = 0;

        if (in.isEmpty()){
            return 1;
        }

        char ch = in.charAt(0);//a
        for(int i = 0; i <= out.length(); i++){
            String f = out.substring(0, i); //(0,0) = null
            String s = out.substring(i, out.length()); //(0,1) = bc
            count = count + permutationsCount(in.substring(1), f + ch + s);
        }

        return count;
    }
}

package com.kapil.preparation.coding.string;

/*
 *  This code prints all permutations of a string with all distinct characters.
 * */
public class StringPermutation {
    public static void main(String[] args) {
        String str = "root";
        permutation(str);
    }

    private static void permutation(String str) {
        permutation(str, "");
    }

    private static void permutation(String str, String prefix) {
//        if (str.length() == 0) {
//            System.out.println(prefix);
//        } else {
//            for (int i = 0; i < str.length(); i++) {
//                String rem = str.substring(0, i) + str.substring(i + 1);
//                permutation(rem, prefix + str.charAt(i));
//            }
//        }

        if (str.isBlank()) System.out.println(prefix);

        for (int i = 0; i < str.length(); i++){
            String rem = str.substring(0, i) + str.substring(i+1);
            permutation(rem, prefix + str.charAt(i));
        }

    }
}

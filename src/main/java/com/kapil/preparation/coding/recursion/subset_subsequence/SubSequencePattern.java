package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * String
 * Array
 * Recursion
 * Subset
 * */
public class SubSequencePattern {
    public static void main(String[] args) {
        System.out.println("subSequence(\"abc\"): " + subSequence("abc"));
        System.out.println("subSequenceAscii(\"ABC\"): " + subSequenceAscii("ABC"));

        int[] arr = {1, 2, 3};
        System.out.println("subSequenceIterative(arr): " + subSequenceIterative(arr));

        int[] arr1 = {1, 2, 2};
        System.out.println("subSequenceIterativeDuplicate(arr1): " + subSequenceIterativeDuplicate(arr1));
    }

    private static List<String> subSequence(String s) {
        return subSequence(s, "");
    }

    private static List<String> subSequence(String in, String out) {
        List<String> list = new ArrayList<>();

        if (in.isEmpty()) {
            list.add(out);
            return list;
        }

        char ch = in.charAt(0);
        list.addAll(subSequence(in.substring(1), out));
        list.addAll(subSequence(in.substring(1), out + ch));

        return list;
    }

    private static List<String> subSequenceAscii(String s) {
        return subSequenceAscii(s, "");
    }

    private static List<String> subSequenceAscii(String in, String out) {
        List<String> list = new ArrayList<>();

        if (in.isEmpty()) {
            list.add(out);
            return list;
        }

        char ch = in.charAt(0);
        list.addAll(subSequenceAscii(in.substring(1), out));
        list.addAll(subSequenceAscii(in.substring(1), out + ch));
        list.addAll(subSequenceAscii(in.substring(1), out + (ch + 0)));

        return list;
    }

    // Time complexity: O(n * 2^n)
    // Space complexity: O(n)
    private static List<List<Integer>> subSequenceIterative(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(Collections.emptyList());

        for (int el : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(el);
                outer.add(inner);
            }
        }

        return outer;
    }

    // Ignores duplicate subset, if duplicate element exists in array
    private static List<List<Integer>> subSequenceIterativeDuplicate(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(Collections.emptyList());

        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();
            int s = 0;
            int e = n - 1;

            if (i > 0 && arr[i] == arr[i - 1]) {
                s = e + 1;
            }

            for (int j = s; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }

        }

//        for (int i = 0; i < arr.length; i++) {
//            int n = outer.size();
//            int start = 0;
//            int end = n - 1;
//
//            // if current & previous element is same, start = end + 1;
//            if (i > 0 && arr[i] == arr[i - 1]) {
//                start = end + 1;
//            }
//
//            for (int j = start; j < n; j++) {
//                List<Integer> inner = new ArrayList<>(outer.get(j));
//                inner.add(arr[i]);
//                outer.add(inner);
//            }
//        }

        return outer;
    }

    private static List<List<Integer>> sudRemoveDuplicate(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(Collections.emptyList());

        for (int el : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(el);
                outer.add(inner);
            }
        }

        return outer;
    }
}

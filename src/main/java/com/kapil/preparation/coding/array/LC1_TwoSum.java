package com.kapil.preparation.coding.array;

import java.util.*;

/*
 * https://leetcode.com/problems/two-sum/
 * */
public class LC1_TwoSum {

    static boolean hasPairWithSum(int[] arr, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int num : arr) {
            if (complements.contains(num)) return true;
            complements.add(sum - num);
        }
        return false;
    }

    static int[] hasPairWithSumGetIndices(int[] arr, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - arr[i];
            if (complements.containsKey(num)) {
                return new int[]{complements.get(num), i};
            }

            complements.put(complement, i);
        }
        return new int[0]; //return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 9, -1, -1, 8};
        int sum = 11;
        System.out.println(hasPairWithSum(arr, sum));
        System.out.println(Arrays.toString(hasPairWithSumGetIndices(arr, sum)));
    }
}

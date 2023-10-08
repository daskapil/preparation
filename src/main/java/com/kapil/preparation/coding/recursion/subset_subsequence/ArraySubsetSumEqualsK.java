package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.List;

/*
* This problem was asked by Google.
* Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
* If such a subset cannot be made, then return null.
* Integers can appear more than once in the list. You may assume all numbers in the list are positive.
* For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
* */
public class ArraySubsetSumEqualsK {
    public static void main(String[] args) {
//        int[] arr = {12, 1, 61, 5, 9, 2};
        int[] arr = { 1, 2, 10, 4};
        int k = 24;
        System.out.println(subsetSum(arr, k));
    }

    private static boolean subsetSum(int[] arr, int k) {
        return subsetSum(arr, k, 0);
    }

    private static boolean subsetSum(int[] arr, int k, int i) {
        if ( k == 0) return true;
        if (i == arr.length) return false;
        if (arr[i] > k) {
            return subsetSum(arr, k, i + 1);
        } else {
            return subsetSum(arr, k - arr[i], i + 1) || subsetSum(arr, k, i + 1);
        }
    }
}

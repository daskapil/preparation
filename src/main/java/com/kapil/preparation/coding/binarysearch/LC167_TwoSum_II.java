package com.kapil.preparation.coding.binarysearch;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * */
public class LC167_TwoSum_II {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{++start, ++end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
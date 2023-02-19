package com.kapil.algorithms.search;

import java.util.Arrays;

/*
 * Time complexity: O(n) - Linear
 * Space complexity: O(1) - Constant
 * */
public class LinearSearch {
    public static void main(String[] args) {
        // Linear Search in Array
        int[] arr = {10, 24, 14, 48, 100, 19};
        int target = 100;
        System.out.println("Linear Search -  : " + linearSearchArray(arr, target));
        System.out.println("Linear Search Array - Boolean  : " + linearSearchArrayBoolean(arr, target));

        // Linear Search in Range of an Array
        int start = 1;
        int end = 4;
        System.out.println("linear Search in Range of an Array: " + linearSearchRangeArray(arr, target, start, end));// Linear Search in Range of an Array

        // Linear search in 2D array
        int[][] arr2D = {
                {11, 24, 14, 48, 100, 19},
                {12, 23},
                {12, 25, 90, 10}
        };
        int num = 10;
        int[] ans = linearSearch2DArray(arr2D, num);
        System.out.println("Linear Search in 2D Array: " + Arrays.toString(ans));

        // Linear Search in String
        String str = "Kapil";
        char searchChar = 'k';
        System.out.println("Linear Search -  : " + linearSearchString(str, searchChar));
        System.out.println("linearSearchArrayBoolean  : " + linearSearchStringForEach(str, searchChar));
    }

    // linear search in Array
    private static int linearSearchArray(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (target == arr[i]) return i;
        }
        return -1;
    }

    private static boolean linearSearchArrayBoolean(int[] arr, int target) {
        for (int n : arr) {
            if (target == n) return true;
        }
        return false;
    }

    // Linear Search in a Range
    private static int linearSearchRangeArray(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (target == arr[i]) return i;
        }
        return -1;
    }

    // Linear Search in a 2D array
    private static int[] linearSearch2DArray(int[][] arr2D, int num) {
        for (int row = 0; row < arr2D.length; row++) {
            for (int col = 0; col < arr2D[row].length; col++) {
                if (arr2D[row][col] == num) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Linear Search in String
    private static boolean linearSearchString(String str, char searchChar) {
        int length = str.length();

        if (length == 0) return false;

        for (int i = 0; i < length - 1; i++) {
            if (searchChar == str.charAt(i)) return true;
        }

        return false;
    }

    private static boolean linearSearchStringForEach(String str, char searchChar) {
        if (str.length() == 0) return false;

        for (char c : str.toCharArray()) {
            if (searchChar == c) return true;
        }

        return false;
    }
}

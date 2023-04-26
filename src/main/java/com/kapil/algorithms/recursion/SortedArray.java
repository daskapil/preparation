package com.kapil.algorithms.recursion;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 10, 11, 12};
        System.out.println(isSorted(arr, 0));
    }

    private static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }
}

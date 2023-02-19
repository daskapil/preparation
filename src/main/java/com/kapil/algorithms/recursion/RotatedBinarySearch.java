package com.kapil.algorithms.recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 10, 12, 11};
        System.out.println(search(arr, 10));
    }

    private static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int s, int e) {
        if (s > e) return -1;

        int m = s + (e - s) / 2;

        if (target == arr[m]) return m;

        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1);
            } else {
                return search(arr, target, m + 1, e);
            }
        }

        if (target >= arr[m] && target <= arr[e]) {
            return search(arr, target, m + 1, e);
        }

        return search(arr, target, s, m - 1);
    }
}

package com.kapil.algorithms.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-28, 0, 10, 20, 23, 45, 87, 100};
        int target = 10;
        System.out.println("*** Binary Search Using Recursion ***");
        System.out.println("Search index: " + search(arr, target));
        System.out.println("Search index - using  Recursive method: " + searchRecursive(arr, target, 0, arr.length - 1));
        System.out.println("Search index - Order Agnostic: " + searchOrderAgnostic(arr, target));
    }

    //Iterative way
    private static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // int mid = (start + end) / 2; // Bad way of finding mid - (start + end) may exceed MAX Integer value
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    //Recursive way
    private static int searchRecursive(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) return mid;

        if (target < arr[mid]) {
            return searchRecursive(arr, target, start, mid - 1);
        }

        return searchRecursive(arr, target, mid + 1, end);
    }

    private static int searchOrderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) return mid;

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

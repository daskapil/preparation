package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * - Choose any element as Pivot(P)
 *   --> after the pass all elements < P will be* on LHS of P.
 *       && elements > P will be on RHS
 *   --> Pivot is on right position and go on
 *
 * - Divide and Conquer algorithm
 * - Uses Recursive algorithm
 * -  Recurrence relation: Arr[N] = {K..., P , (N - K - 1)..}
 *    T(N) = T(K) + T(N - K - 1) + O(N) =>
 * - Unstable
 * - In place
 * - Worst case time complexity: O(n^2)
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }

            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // e will reach at current pivot index - 1
        // s will reach at current pivot index + 1
        // now my pivot is at correct index, please sort two halves now
        sort(arr, low, e);
        sort(arr, s, high);
    }
}

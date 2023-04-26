package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * Merge Sort:
 *   -  Divide and conquer algorithm
 *   - Uses Recursive algorithm
 *   - Two Phases: Splitting & Merging
 *   - Splitting phases leads to faster sorting during the merge phase
 *   - Splitting is logical. we don't create new arrays
 *   - NOT an in-place algorithm
 *   - Time Complexity: O(n log n) - base 2; because we are repeatedly splitting the array
 *     in half during the splitting phase
 *   - Space Complexity: O(n)
 *   - Stable logarithmic algorithm
 * */
public class MargeSort2 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr); //in-place
        System.out.println(Arrays.toString(arr));
    }



    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length/ 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(arr, left, right);
    }

    private static int[] merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[i] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr;
    }


}

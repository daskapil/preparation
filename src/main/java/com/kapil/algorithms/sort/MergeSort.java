package com.kapil.algorithms.sort;

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


import com.kapil.learn.oops.learn.A;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        arr = mergeSort(arr);
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSortInPlace(arr, s, m);
        mergeSortInPlace(arr, m, e);
        mergeInPlace(arr, s, m, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        System.arraycopy(mix, 0, arr, s + 0, mix.length);
        /*for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }*/
    }


    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int len = arr.length;
        int mid = len / 2;

        //Splitting of array
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, len));

        //merging the array
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}

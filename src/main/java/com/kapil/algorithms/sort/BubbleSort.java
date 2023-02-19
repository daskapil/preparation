package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping
 * the adjacent elements if they are in wrong order.Always runs O(n^2) time even if
 * the array is sorted. It can be optimized by stopping the algorithm if inner loop
 * didn’t cause any swap.
 *
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 * */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        int[] intArray = {5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(bubbleSort(intArray)));

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            boolean swapped = false;

            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped) break;
        }

        System.out.println(Arrays.toString(intArray));
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Just Practice
    public static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j,  j + 1);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return arr;
    }
}

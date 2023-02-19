package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * The selection sort algorithm sorts an array by repeatedly finding the maximum
 * element(considering ascending order) from unsorted part and putting it at the
 * last. The algorithm maintains two sub-arrays in a given array.
 * 1) The sub-array which is already sorted.
 * 2) Remaining sub-array which is unsorted.
 *
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) swaps
 * and can be useful when memory write is a costly operation.
 * Stable: No
 * */
public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;

            for (int i = 0; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }

            swap(intArray, largest, lastUnsortedIndex);

            //lastUnsortedIndex = 7 -1 = 6
            // i = 0,largest = 0, intArray[i] /*20*/ > intArray[largest] /*20*/ ==> false
            // i = 1,largest = 0, intArray[i] /*35*/ > intArray[largest] /*20*/ ==> true
            //       largest = i = 1
            // i = 2,largest = 1, intArray[i] /*-15*/ > intArray[largest] /*35*/ ==> false
            // i = 3,largest = 1, intArray[i] /*7*/ > intArray[largest] /*35*/ ==> false
            // i = 4,largest = 1, intArray[i] /*55*/ > intArray[largest] /*35*/ ==> true
            //       largest = i = 4
            // i = 5,largest = 4, intArray[i] /*1*/ > intArray[largest] /*55*/ ==> false
            // i = 6,largest = 4, intArray[i] /*-15*/ > intArray[largest] /*55*/ ==> false
            // Swap - largest(4) with lastUnsortedIndex(6) => [20, 35, -15, 7, -22, 1, 55]

            //lastUnsortedIndex-- ==> 5
            // i = 0,largest = 0, intArray[i] /*20*/ > intArray[largest] /*20*/ ==> false
            // i = 1,largest = 0, intArray[i] /*35*/ > intArray[largest] /*20*/ ==> true
            //       largest = i = 1
            // i = 2,largest = 1, intArray[i] /*-15*/ > intArray[largest] /*35*/ ==> false
            // i = 3,largest = 1, intArray[i] /*7*/ > intArray[largest] /*35*/ ==> false
            // i = 4,largest = 1, intArray[i] /*-22*/ > intArray[largest] /*35*/ ==> false
            // i = 5,largest = 1, intArray[i] /*1*/ > intArray[largest] /*35*/ ==> false
            // Swap - largest(1) with lastUnsortedIndex(5) => [20, 1, -15, 7, -22, 35, 55]
            // so on
        }

        System.out.println(Arrays.toString(intArray));

        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }

    private static void swap(int[] intArray, int largest, int lastUnsortedIndex) {
        if (largest == lastUnsortedIndex) return;

        int temp = intArray[lastUnsortedIndex];
        intArray[lastUnsortedIndex] = intArray[largest];
        intArray[largest] = temp;
    }


    //for practice
    public static int[] selectionSort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            int largestAt = 0;

            for (int j = 0; j <= i; j++) {
               if(arr[j]>arr[largestAt]) {
                   largestAt = j;
               }
            }

            swapNew(arr, largestAt, i);
        }
        return arr;
    }

    static void swapNew(int[] arr, int largestAt, int last){
        if(largestAt == last) return;

        int tmp = arr[last];
        arr[last] = arr[largestAt];
        arr[largestAt] = tmp;
    }
}

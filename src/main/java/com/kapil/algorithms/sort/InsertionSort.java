package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
 * The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and
 * placed at the correct position in the sorted part.
 * Algorithm:
 * To sort an array of size n in ascending order:
 *      1: Iterate from arr[1] to arr[n] over the array.
 *      2: Compare the current element (key) to its predecessor.
 *      3: If the key element is smaller than its predecessor, compare it to the elements before.
 *         Move the greater elements one position up to make space for the swapped element.
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 * Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
 * And it takes minimum time (Order of n) when elements are already sorted.
 * Algorithmic Paradigm: Incremental Approach
 * Sorting In Place: Yes
 * Stable: Yes
 * Online: Yes
 * Uses: Insertion sort is used when number of elements is small. It can also be useful when input
 * array is almost sorted, only few elements are misplaced in complete big array.
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            //firstUnsortedIndex = 1, intArray[firstUnsortedIndex] = 35
            //firstUnsortedIndex = 2, intArray[firstUnsortedIndex] = -15

            int i = firstUnsortedIndex;
            for (; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
                //firstUnsortedIndex = 1
                //i=1 && ntArray[i - 1] /*20*/ > newElement /*35*/ ==> false, exist this loop
                // intArray = [20, 35, -15, 7, 55, 1, -22] - no change

                //firstUnsortedIndex = 2
                //i=2 && intArray[i - 1] i.e  35 > newElement /*-15*/ => true
                //      intArray[2] = 35; // intArray = [20, 35, 35, 7, 55, 1, -22]
                //i-- => i = 1 && intArray[i - 1] /*20*/ > newElement /*-15*/ => true
                //      intArray[1] = 20; // intArray = [20, 20, 35, 7, 55, 1, -22]
                //i-- => i = 0 && i> 0 => false,exist this loop
                // intArray = [20, 20, 35, 7, 55, 1, -22]

            }

            intArray[i] = newElement;
            // After completion of inner loop when firstUnsortedIndex = 2
            // i= 0, intArray[0] =  -15
            //-15, 20, 35, 7, 55, 1, -22
            //so on

        }
        System.out.println(Arrays.toString(intArray));

        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(insertionSortUsingWhile(arr)));

        int[] arr1 = {20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(insertionSortDecreasingOrder(arr1)));
    }

    static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++){
            int tmp = arr[i];

            int j = i;
            for (; j > 0 && arr [j - 1] > tmp; j--){
                arr[j] = arr[j - 1];
            }

            arr[j] = tmp;
        }

        return arr;
    }

    static int[] insertionSortUsingWhile(int[] arr) {
        for (int i = 1; i <arr.length; i++){
            int key = arr[i];

            int j = i;
            while (j > 0 && arr[j - 1]> key) {
                arr[j] = arr [ j - 1];
                j--;
            }

            arr[j] = key;
        }
        return arr;
    }

    static int[] insertionSortDecreasingOrder(int[] arr) {
        for (int i = 1; i <arr.length; i++){
            int key = arr[i];

            int j = i;
            while (j > 0 && arr[j - 1] < key) {
                arr[j] = arr [ j - 1];
                j--;
            }

            arr[j] = key;
        }
        return arr;
    }
}

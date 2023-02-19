package com.kapil.algorithms.sort;

import java.util.Arrays;

/*
 * ShellSort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead.
 * When an element has to be moved far ahead, many movements are involved. The idea of shellSort is to allow
 * exchange of far items. In shellSort, we make the array h-sorted for a large value of h. We keep reducing
 * the value of h until it becomes 1. An array is said to be h-sorted if all sub-lists of every h’th element is sorted.
 * Time Complexity:  O(n*n).
 * */
public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        int length = intArray.length;

        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;

                // Outer for-> gap = 7/2 = 3,
                //    Inner For -> i = 3, newElement = intArray[i  or 3] = 7; j = 3; j >= gap && intArray[(j - gap) or 0] /*20*/> newElement /*7*/ => true;
                //          while -> intArray[j or 3] = 20; j -= gap => j = 0; [20, 35, -15, 20, 55, 1, -22] exit while; intArray[j] = newElement = 7; [7, 35, -15, 20, 55, 1, -22]
                //     i++ => 4; newElement = intArray[i] /*55*/
                //          while -> j = 4, j >= gap && intArray[(j - gap) or 1] /*35*/> newElement /*55*/ => false; exit while; no change
                //     i++ => 5; newElement = intArray[i] /*1*/
                //          while -> j = 5, j >= gap && intArray[(j - gap) or 2] /*-15*/> newElement /*1*/ => false; exit while; no change
                //     i++ => 6; newElement = intArray[i] /*-22*/
                //          while -> j = 6, j >= gap && intArray[(j - gap) or 3] /*20*/> newElement /*-22*/ => true; [7, 35, -15, 20, 55, 1, 20]; j -= gap => j = 3;
                //                   j = 3; j >= gap && intArray[(j - gap) or 0] /*7*/> newElement /*-22*/ => true; [-22, 35, -15, 20, 55, 1, 20]; j -= gap => j = 0; [-22, 35, -15, 7, 55, 1, 20];
                //     Inner For -> exit; gap /= 2 => 1
            }
        }
        System.out.println(Arrays.toString(intArray));
    }

    private static int[] shellSort(int[] arr) {
        int l = arr.length;

        for (int gap = l /2; gap > 0; gap /= 2){
            for (int i = gap; i < l; i++) {
                int tmp = arr[i];

                int j = i;
                while(j >= gap && arr[j - gap]> tmp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = tmp;
            }
        }
        return arr;
    }

}

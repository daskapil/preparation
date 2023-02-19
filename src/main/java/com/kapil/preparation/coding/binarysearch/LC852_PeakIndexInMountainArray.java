package com.kapil.preparation.coding.binarysearch;

/*
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * */
public class LC852_PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 4, 3, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // Downhill
                // this may be the ans, but look on left; that's why end != mid - 1
                // therefore from start till mid
                end = mid;
            } else {
                // uphill if(arr[mid] < arr[mid + 1])
                start = mid + 1;
            }
        }

        return start;
    }
}

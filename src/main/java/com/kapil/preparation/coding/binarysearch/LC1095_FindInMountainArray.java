package com.kapil.preparation.coding.binarysearch;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-in-mountain-array/
 * */
public class LC1095_FindInMountainArray {
    public static void main(String[] args) {
//        int[] mountainArr = {2, 5, 7, 8, 9, 10, 12, 23, 15, 13, 11, 6, 4, 1};
        int[] mountainArr = {1, 5, 2};
        int target = 3;
        System.out.println(findInMountainArray(11, mountainArr));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        // Step - 1: Find the peak of the mountain array
        int peakIndex = findPeakIndex(mountainArr);

        // Step - 2: Check if target == peak
        if (target == mountainArr[peakIndex]) {
            return peakIndex;
        }

        // Step - 3: Find on increament part og mountain array till (peak - 1)
        // start = 0, end = peak - 1
        int ans = binarySearch(mountainArr, target, 0, peakIndex - 1, true);

        // Step - 4: If target not found in Step - 3,
        // Find on decrementing side of mountain array from (peak + 1 ) till end of array
        // start = peak + 1, end = mountainArr.length() - 1
        if (ans == -1) {
            ans = binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length - 1, false);
        }

        return ans;
    }

    private static int binarySearch(int[] mountainArr, int target, int start, int end, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr[mid];

            if (target == midElement) {
                return mid;
            }

            if (isAsc) {
                if (target < midElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < midElement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    private static int findPeakIndex(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] > mountainArr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


}



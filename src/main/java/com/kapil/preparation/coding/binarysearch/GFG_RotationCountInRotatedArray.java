package com.kapil.preparation.coding.binarysearch;

/*
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 * */
public class GFG_RotationCountInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
//        int[] arr = {15, 15, 18, 18, 2, 3, 6, 12};
        System.out.println(countRotation(arr));
    }

    private static int countRotation(int[] arr) {
        int pivot = findPivot(arr);
//        int pivot = findPivotWithDuplicates(arr);
        return pivot + 1;
    }

    //for non-duplicate array
    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midEl = arr[mid];

            if (mid < end && midEl > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && midEl < arr[mid - 1]) {
                return mid - 1;
            }

            if (midEl < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1; //when it is not a rotated array
    }

    //for array with duplicate elements
    private static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midEl = arr[mid];

            if (mid < end && midEl > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && midEl < arr[mid - 1]) {
                return mid - 1;
            }

            if (midEl == arr[start] && midEl == arr[end]) {
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (midEl > arr[start] || (midEl == arr[start] && midEl > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (midEl < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1; //when it is not a rotated array
    }
}

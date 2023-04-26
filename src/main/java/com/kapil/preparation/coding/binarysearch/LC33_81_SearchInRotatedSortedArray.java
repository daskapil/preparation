package com.kapil.preparation.coding.binarysearch;

/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 *
 * findPivot(nums) method is the only difference between the above two problem
 * */
public class LC33_81_SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {4, 5, 6, 6, 7,-1, 0, 1, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
//        int pivot = findPivot(nums); //// LeetCode # 33
        int pivot = findPivotWithDuplicates(nums); // LeetCode # 81
        int length = nums.length - 1;

        //Array is not a Rotated Sorted Array. It is a regular sorted array.
        //Hence, simple binary search needs to be applied
        if (pivot == -1) return binarySearch(nums, target, 0, length);

        if (target == nums[pivot]) return pivot;

        // if the target >= start, target must lay in first sorted part of array
        if (target >= nums[0]) return binarySearch(nums, target, 0, pivot - 1);

        // Otherwise it would be in 2nd part of sorted array
        return binarySearch(nums, target, pivot + 1, length);

    }

    //this method will not work for Array with duplicate elements
    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 1. if mid element > mid + 1 element found, mid will be the pivot
            // mid has to be smaller than end to avoid ArrayIndexOutOfBoundException
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // 2. if mid element < mid - 1 element found, (mid - 1) will be the pivot
            // mid has to be greater than start to avoid ArrayIndexOutOfBoundException
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] <= nums[start]) {
                // 3. if mid <= start, pivot will must lay before the mid element,
                // because all numbers after mid will be smaller than start.
                // if mid is pivot, it had been returned in step 1 and 2;
                // Therefore, start = previous start, end = mid -1
                end = mid - 1;
            } else {
                // 4. if mid > start, pivot will must lay after the mid element,
                // Therefore, start = mid + 1, end = previous end
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midEl = nums[mid];

            if (mid < end && midEl > nums[mid + 1]) {
                return mid;
            }

            if (mid > start && midEl < nums[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (midEl == nums[start] && midEl == nums[end]) {
                //Skip the duplicates, but make sure they are not pivot
                // check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // check if end - 1 is pivot
                if (end < start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < midEl || (nums[start] == midEl && midEl > nums[end])) {
                // left side is sorted, so pivot should be in right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

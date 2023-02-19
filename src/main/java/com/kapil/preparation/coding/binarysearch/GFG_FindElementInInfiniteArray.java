package com.kapil.preparation.coding.binarysearch;

/*
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * Company: Amazon
 * */
public class GFG_FindElementInInfiniteArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 8, 10, 15, 17, 20, 25, 36, 37, 39, 40, 42, 43, 45, 47, 50, 52, 61, 72, 73, 74, 76, 87, 91, 93, 94, 95, 96, 98, 99, 100};
        int target = 17;
        System.out.println(findElement(nums, target));
    }

    private static int findElement(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while (target >= nums[end]) {
            int temp = end + 1;
            //end *= 2;
            // end = previous end + sizeOfBox * 2;
            // sizeOfBox = (end - start + 1)
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(nums, target, start, end);
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

package com.kapil.preparation.coding.binarysearch;

public class CeilingAndFloorNumber {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -5, 0, 10, 19, 50, 100};
        int target = 8;
        int ceilingNumber = findCeilingNumber(arr, target);
        int floorNumber = findFloorNumber(arr, target);
        System.out.println("Ceiling number index of " + target + ": " + ceilingNumber);
        System.out.println("Floor number index of " + target + ": " + floorNumber);
    }

    private static int findCeilingNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //When target number is greater than the greatest number in the array
        if (target > arr[end]) return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return start;
    }

    private static int findFloorNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //When target number is smaller than the smallest number in the array
        if (target < arr[start]) return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return end;
    }
}

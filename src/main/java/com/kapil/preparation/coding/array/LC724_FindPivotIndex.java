package com.kapil.preparation.coding.array;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-pivot-index/
 * Easy
 * */
public class LC724_FindPivotIndex {

    /*
    * Time complexity: O(n)
    * Space complexity: O(1)
    * */
    public static int pivotIndex(int[] nums) {
        int sumOfArray = Arrays.stream(nums).sum();
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
           if (leftSum == sumOfArray - leftSum - nums[i]) return i;
           leftSum += nums[i];
        }
        return -1;
    }

    public static int pivotIndex_brutForce(int[] nums) {
        int sumOfArray = Arrays.stream(nums).sum();
        System.out.println("Sum of array: " + sumOfArray);

        int i = 0;
        int n = nums.length;
        while (i < n) {
            if ((i == 0 || i == n - 1)) {
                if (sumOfArray == nums[i]) return i;
            } else {
                if (sum(nums, 0, i - 1) == sum(nums, i + 1, n - 1)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    static int sum(int[] nums, int s, int e) {
        int sum = 0;
        while (s <= e) {
            sum += nums[s];
            s++;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, -1, 2};
        int[] nums = {-1, -1, 0, 0, 1, 1};
        System.out.println("Pivot Index: " + pivotIndex(nums));
    }
}

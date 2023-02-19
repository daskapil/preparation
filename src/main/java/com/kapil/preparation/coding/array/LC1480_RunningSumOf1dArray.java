package com.kapil.preparation.coding.array;


import java.util.Arrays;

/*
 *
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * Easy
 * */
public class LC1480_RunningSumOf1dArray {

    public static int[] runningSum(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            nums[i] += nums [i - 1];
            i++;
        }
        return nums;
    }

    public static int[] runningSum_brutForce(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            sums[i] = sum;
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}

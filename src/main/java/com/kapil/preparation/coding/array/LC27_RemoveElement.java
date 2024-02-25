package com.kapil.preparation.coding.array;


/*
 * https://leetcode.com/problems/remove-element
 * Easy
 * */
public class LC27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int result = removeElement(nums, val);
        System.out.println(result);
    }

    //O(n)
    private static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
               nums[index++] = nums[i];
            }
        }
        return index;
    }
}

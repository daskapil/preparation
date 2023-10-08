package com.kapil.preparation.coding.array;

public class LC26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                nums[++slow] = nums[i];
            }
        }
        return slow + 1;
    }
}

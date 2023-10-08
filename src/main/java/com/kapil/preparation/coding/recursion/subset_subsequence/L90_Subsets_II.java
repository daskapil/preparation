package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* https://leetcode.com/problems/subsets-ii/description/
*
* Time Complexity: O(n.2^n)
* */
public class L90_Subsets_II {

    static void backtracking(int[] nums, int index, List<Integer> inner, List<List<Integer>> outer) {
        if (index == nums.length) {
            outer.add(List.copyOf(inner));
            return;
        }

        // Include
        inner.add(nums[index]);
        backtracking(nums,index + 1, inner, outer);
        // Exclude
        inner.remove(inner.size() -1);

        while( index + 1 < nums.length && nums[index] == nums[index + 1]){
            index += 1;
        }
        backtracking(nums,index + 1, inner, outer);

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        backtracking(nums, 0, inner, outer);
        return outer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3};
//        int[] nums = new int[]{0};
        System.out.println(subsetsWithDup(nums));
    }
}

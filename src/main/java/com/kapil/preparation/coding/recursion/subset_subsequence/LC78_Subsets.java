package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/
 * */
public class LC78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        int index = 0;
        subsets(nums, index, inner, outer);
        return outer;
    }

    private static void subsets(int[] nums, int index, List<Integer> inner, List<List<Integer>> outer) {
        //base case
        if (index >= nums.length) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        //include
        inner.add(nums[index]);
        subsets(nums, index + 1, inner, outer);

        //exclude
        inner.remove(inner.size() - 1);
        subsets(nums, index + 1, inner, outer);
    }

    public static List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Collections.EMPTY_LIST);

        for (int num : nums) {
            int n = ans.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(ans.get(i));
                inner.add(num);
                ans.add(inner);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{0};
        System.out.println(subsets(nums));
    }

}

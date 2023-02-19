package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90_Subsets_II {

    static void solve(int[] nums, int index, List<Integer> inner, List<List<Integer>> outer) {
        outer.add(new ArrayList<>(inner));

        //for ()
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0;
        solve(nums, index, inner, outer);
        return outer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{0};
        System.out.println(subsetsWithDup(nums));
    }
}

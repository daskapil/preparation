package com.kapil.preparation.coding.recursion.subset_subsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC46_Permutations {

    private static List<List<Integer>> permute(int[] nums) {
        List<Integer> in = IntStream.range(0, nums.length).boxed().collect(Collectors.toList());
        return permute(in, new ArrayList<>());
    }

    private static List<List<Integer>> permute(List<Integer> in, List<Integer> out) {
        List<List<Integer>> list = new ArrayList<>();

        if (in.isEmpty()) {
            list.add(out);
            return list;
        }

        int n = in.get(0);
        List<Integer> inner = new ArrayList<>();
        for (int i = 0; i <= out.size(); i++) {

        }

        return list;
    }
}

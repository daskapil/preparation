package com.kapil.preparation.coding.array;

import java.util.*;

/*
 * https://leetcode.com/problems/3sum/
 * */
public class LC15_3Sum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        //        int[] arr = {-2, 0, 0, 2, 2};
//        int[] arr = {1, 0};
//        int[] arr = {};
        System.out.println("Three Sum:");
        System.out.println(threeSum(arr));

        System.out.println("Three Sum using Set:");
        System.out.println(threeSum_UsingSet(arr));

        System.out.println("three Sum Brute Force:");
        System.out.println(threeSum_BruteForce(arr));
    }


    /*
     * Time complexity: O(nlog n) + O(n^2) => O(n^2)
     * Space Complexity: O(n)
     * This is faster than the solution with set
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums); //O(nlog n)

        int target = 0;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) { // O(n)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1;
            int end = n - 1;
            while (start < end) { // O(n)
                int threeSum = nums[i] + nums[start] + nums[end];

                if (threeSum == target) {
                    results.add(List.of(nums[i], nums[start], nums[end]));
                    start++;

                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    end--;
                } else if (threeSum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return results;
    }

    /*
     * Time complexity: O(nlog n) + O(n^2) => O(n^2)
     * Space Complexity: O(n)
     * */
    public static List<List<Integer>> threeSum_UsingSet(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return Collections.emptyList();
        }

        int target = 0;
        Arrays.sort(nums);

        Set<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int threeSum = nums[i] + nums[start] + nums[end];

                if (threeSum == target) {
                    results.add(List.of(nums[i], nums[start++], nums[end--]));
                } else if (threeSum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(results);
    }

    public static List<List<Integer>> threeSum_BruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }

                }
            }
        }

        return result;
    }

    private static List<Integer> twoSum(int[] arr, int target) {
        Map<Integer, Integer> comps = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int comp = target - curr;
            if (comps.containsKey(comp)) {
                return List.of(comps.get(comp), i);
            }

            comps.put(comp, i);
        }

        return List.of(-1);
    }
}

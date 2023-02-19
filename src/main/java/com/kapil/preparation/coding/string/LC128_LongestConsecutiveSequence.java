package com.kapil.preparation.coding.string;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Medium
 * */
public class LC128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n <= 1) return n;

        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet()); //O(n)

        int longest = 0;
        for (int num: set){
            //Check if its start of a sequence
            if(!set.contains(num - 1)) { //O(1)
                int count = 0;
                while(set.contains(num + count)){
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
    // Time complexity : O(n log n) + O(n) => O(n log n),
    // However, we need O(n) solution
    public static int longestConsecutive_nlogn(int[] nums) {
        int n = nums.length;

        if(n <= 1) return n;

        Arrays.sort(nums); //O(n log n)

        int max = 1;
        int count = 1;
        for (int i = 1; i < n; i++){ //O(n)
            if (nums[i] == nums[i - 1] + 1){
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
       int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}

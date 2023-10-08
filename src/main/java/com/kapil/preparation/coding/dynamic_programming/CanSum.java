package com.kapil.preparation.coding.dynamic_programming;

/*
Write a function 'canSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
The function should return a boolean indicating whether it is possible to generate the targetSum usinf numbers frim the array.
you may use an elements of the array as many times as needed.
You may assume that all input numbers are nonnegative.

canSum(7, [5, 4, 3, 7]) -> true
canSum(5u, [2, 4]) -> false

m = target sum
n = array length

Brute force
-----------------
Time complexity: O(n^m)
Space complexity: O(m)

Memoized fo rce
-----------------
Time complexity: O(m * n)
Space complexity: O(m)
*/

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new  int[] {2, 3})); //true
        System.out.println(canSum(7, new  int[] {5, 3, 4, 7})); //true
        System.out.println(canSum(7, new  int[] {2, 4})); // false
        System.out.println(canSum(8, new  int[] {2, 3, 5})); //true
        System.out.println(canSum(300, new  int[] {7, 14})); // false
    }

    public static boolean canSum(int targetSum, int[] numbers) {
        return canSum(targetSum, numbers, new HashMap<>());
    }
    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num: numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }
}

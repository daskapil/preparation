package com.kapil.preparation.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Given five positive integers, find the minimum and maximum values that can be
* calculated by summing exactly four of the five integers. Then print the respective
* minimum and maximum values as a single line of two space-separated long integers.
*
* Example: arr = [1, 3, 5, 7, 9]
* The minimum sum is 1 + 3 + 5 + 7 = 16 and the maximum sum is 3 + 5 + 7 + 9 = 24.
* The function prints - 16 24
* */
public class MiniMaxSum {

    private static void miniMaxSum(List<Integer> arr) {
        System.out.println(arr);

        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        System.out.println(sum);
        System.out.println("Min = " + (sum - max));
        System.out.println("Max = " + (sum - min));

    }


    public static void main(String[] args) {
        miniMaxSum(Arrays.asList(1, 2, 3, 5, 9));
    }
}

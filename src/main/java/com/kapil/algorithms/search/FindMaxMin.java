package com.kapil.algorithms.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMaxMin {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        //Linear Search
        System.out.println("Max: " + max(arr));
        System.out.println("Min: " + min(arr));

        //Functional Programming
        MaxFunctionalProgramming(arr);

        //Collections - Converting into List
        minUsingCollections(arr);
    }

    private static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    private static void MaxFunctionalProgramming(int[] arr) {
        System.out.println("Max - FunctionalProgramming: ");
        System.out.println("Max using Arrays.stream(arr).max(): " + Arrays.stream(arr).max().getAsInt());
        System.out.println("Max using IntStream.range(0, arr.length): " + IntStream.range(0, arr.length).map(i -> arr[i]).max().getAsInt());

        IntSummaryStatistics summaryStatistics = Arrays.stream(arr).summaryStatistics();
        System.out.println("Max using IntSummaryStatistics: " + summaryStatistics);
    }

    private static void minUsingCollections(int[] arr) {
        List<Integer> listOfInteger = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Max by converting int a List: " + Collections.min(listOfInteger));
    }
}

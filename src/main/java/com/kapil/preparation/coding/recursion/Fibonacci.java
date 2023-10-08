package com.kapil.preparation.coding.recursion;

import com.kapil.learn.collections.HashMapInternal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.EMPTY_MAP;

/*
 * Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *
 * FIn mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,[1]
 * F_{0} = 0, F_{1} = 1
 * and
 * F_{n} = F_{n-1} + F_{n-2}
 * for n > 1.
 */
public class Fibonacci {
    static int max = 50;
    static int[] memories = new int[max + 1];

    public static void main(String[] args) {
        int index = 50;
//        for (int i = 0; i <= index; i++) {
//            System.out.println("F_{" + i + "}: " + fibonacci(i));
//            System.out.println("F_{" + i + "}: " + fibonacciOptimized(i));
//        }
//        System.out.println("F_{" + index + "}: " + fibonacci(index));
//        System.out.println("F_{" + index + "}: " + fibonacciOptimized2(index));
        System.out.println("F_{" + index + "}: " + fibonacciOptimized(index));
        System.out.println("F_{" + index + "}: " + fibonacciDynamic(index));
    }

    private static long fibonacci(int index) {
        if (index == 0 || index == 1) return index;
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    //Top-down Dynamic Programming (Memorization) approach
    private static long fibonacciOptimized(int n) {
        return fibonacciOptimized(n, new long[n + 1]);
    }

    private static long fibonacciDynamic(int n) {
        return fibonacciDynamic(n, new HashMap<>());
    }

    private static long fibonacciOptimized(int n, long[] memories) {
        if (n <= 1) return n;

        if (memories[n] == 0) {
            memories[n] = fibonacciOptimized(n - 1, memories) + fibonacciOptimized(n - 2, memories);
        }

        return memories[n];
    }

    //Bottom-Up Dynamic Programming (Memorization) approach
    private static long fibonacciOptimized2(int n) {
        if (n <= 1) return n;

        long[] memories = new long[n];
        memories[0] = 0;
        memories[1] = 1;
        for (int i = 2; i < n; i++) {
            memories[i] = memories[i - 1] + memories[i - 2];
        }
        return memories[n - 1] + memories[n - 2];
    }


    private static long fibonacciDynamic(int n, Map<Integer, Long> memo) {
        if (n <= 2) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        memo.put(n, fibonacciDynamic(n - 1, memo) + fibonacciDynamic(n - 2, memo));
        return memo.get(n);

    }
}

package com.kapil.preparation.coding.recursion;

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
    public static void main(String[] args) {
        int index = 50;
//        for (int i = 0; i <= index; i++) {
////            System.out.println("F_{" + i + "}: " + fibonacci(i));
//            System.out.println("F_{" + i + "}: " + fibonacciOptimized(i));
//        }
        System.out.println("F_{" + index + "}: " + fibonacci(index));
        System.out.println("F_{" + index + "}: " + fibonacciOptimized(index));
    }

    private static long fibonacci(int index) {
        if (index == 0 || index == 1) return index;
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    //Top-down Dynamic Programming (Memorization) approach
    private static long fibonacciOptimized(int n) {
        return fibonacciOptimized(n, new int[n + 1]);
    }

    private static int fibonacciOptimized(int n, int[] memories) {
        if (n == 0 || n == 1) return n;

        if (memories[n] == 0) {
            memories[n] = fibonacciOptimized(n - 1, memories) + fibonacciOptimized(n - 2, memories);
        }

        return memories[n];
    }


}

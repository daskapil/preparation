package com.kapil.algorithms.recursion;

//Simple recursion examples
public class PrintNumbers {

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
        System.out.println("=======================");
        printNumbersDesc(n);
    }

    private static void printNumbers(int n) {
        printNumbers(1, n);
    }

    private static void printNumbers(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        printNumbers(i + 1, n);
    }

    //print n to 1
    private static void printNumbersDesc(int n) {
        if (n == 0) return;
        System.out.println(n);
        printNumbersDesc(n - 1);
    }
}

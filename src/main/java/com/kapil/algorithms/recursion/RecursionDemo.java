package com.kapil.algorithms.recursion;

public class RecursionDemo {

    public static void main(String[] args) {
//        printDemo(1);
//        nto1(5);
//        System.out.println(factorial(5));
//        System.out.println(sumOfDigits(123456));
//        System.out.println(reverseNum(123456));
        System.out.println(countZerosRecursive(10001000));
    }

    private static void printDemo(int n) {
        System.out.println(n);
        if (n == 5) return;
        printDemo(n + 1);
    }

    private static void nto1(int n) {
        if (n == 0) return;
        System.out.println(n);
        nto1(n - 1);
        System.out.println(n);
    }

    private static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }

    private static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }

    private static int reverseNum(int n) {
        if (n == 0) return n;
        int rem = n % 10;
//        int sum = sum * 10 + rem;
        return (n % 10) * 10 + reverseNum(n / 10);
    }

    private static int countZeros(int n) {
        if (n == 0) return 1;
        int count = 0;

        while (n != 0) {
            if (n % 10 == 0) {
                count = count + 1;
            }
            n /= 10;
        }
        return count;
    }

    private static int countZerosRecursive(int n) {
        if (n == 0) return 1;
        return countZ(n, 0);
    }

    private static int countZ(int n, int count) {
        if (n == 0) return count;
        if (n % 10 == 0) count += 1;
        return countZ(n / 10, count);
    }

}

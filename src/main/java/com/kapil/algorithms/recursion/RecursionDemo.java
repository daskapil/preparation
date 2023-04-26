package com.kapil.algorithms.recursion;

public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println("Sum of digits = " + sumOfDigits(123456));
        System.out.println(countZeros(10001000));
        System.out.println(countZerosRecursive(10001000));
    }

    private static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }


    private static int countZeros(int n) {
        int count = 0;
        while(n != 0) {
            if(n % 10 == 0) count++;
            n/=10;
        }
        return count;
    }

    private static int countZerosRecursive(int n) {
        return countZerosRecursive(n, 0);
    }
    private static int countZerosRecursive(int n, int count) {
        if (n == 0) return count;
        if (n % 10 == 0) count += 1;
        return countZerosRecursive(n / 10, count);
    }

}

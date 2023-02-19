package com.kapil.preparation.coding.math;

/*
 * Check a number is a Prime number:
 * If n is divisible by a number which greater its square-root than it's divisible by
 * smaller numbers. Hence, we are looping till its square-root
 * */
public class PrimeNumber {
    static boolean isPrime(int num) {
        for (int x = 2; x <= Math.sqrt(num); x++) {
            if (num % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 13;
        System.out.println("Is " + num + " prime? " + isPrime(num));
    }
}

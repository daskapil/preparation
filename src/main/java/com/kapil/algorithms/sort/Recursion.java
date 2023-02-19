package com.kapil.algorithms.sort;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(iterativeFactorial(1));
//        System.out.println(factorial(4));
//        printNumber(1);
        int fibonacci = fibonacci1(4);
        System.out.println("Fibonacci(4): " + fibonacci);
    }

    private static void printNumber(int n) {
        System.out.println(n);
        if (n < 5) {
            printNumber(n + 1);
        }
    }


    // Factorial
    // 0! = 1
    // 1! = 1 * 0!
    // 2! = 2 * 1!
    // 3! = 3 * 2!
    // 4! = 4 * 3!
    // n! = n * (n - 1)!
    private static long recursiveFactorial(int num) {
        if (num == 0) return 1;
        return num * recursiveFactorial(num - 1);
    }

    private static long iterativeFactorial(int num) {
        if (num == 0) return 1;

        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //nth Fibonacci number
    // 0,1,1,2,3,5,8,13,21 ...
    // Fibonacci(n) = Fibonacci(n - 1) + Fibonacci(n - 2)
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int fibonacci1(int n){
        if(n <= 1) return n;
        return fibonacci1(n-1) + fibonacci(n - 2);
    }
}

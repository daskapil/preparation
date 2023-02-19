package com.kapil.preparation.coding.math;

/*
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * Easy
 * */
public class LC1342_NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));

    }

    public static int countSteps(int num) {
        if (num == 1) return 1;
        int c = 0;
        if (num % 2 != 0) c++;
        return countSteps(num / 2) + 1 + c;
    }

    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper(int n, int steps) {
        if (n == 0) return steps;

        if (n % 2 != 0) {
            steps++;
            n--;
        } else {
            n /= 2;
            steps++;
        }

        return helper(n, steps);
    }
}

package com.kapil.preparation.coding.math;

import java.util.Arrays;

public class LC1295_EvenNumberDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};

        int noOfEvenDigits = findNumbersString(nums);
        int noOfEvenDigits2 = findNumbersLog(nums);
        System.out.println(noOfEvenDigits);
        System.out.println(noOfEvenDigits2);
    }

    // Approach: 1
    public static int findNumbersString(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    // Approach: 2
    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (digits(num) % 2 == 0)
                count++;
        }
        return count;
    }

    private static int digits(int num) {
        if (num == 0) return 1;

        if (num < 0) {
            num *= -1;
        }

        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    // Approach: 3
    public static int findNumbersLog(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (num < 0) {
                num *= -1;
            }
            System.out.println(Math.log10(num));
            int digits = num == 0 ? 1 : (int) Math.log10(num) + 1;

            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}

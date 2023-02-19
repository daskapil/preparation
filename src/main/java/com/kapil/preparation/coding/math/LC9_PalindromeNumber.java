package com.kapil.preparation.coding.math;

public class LC9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }


    //better solution
    //Time complexity : O(log_{10}(n)).We divided the input by 10 for every iteration, so the time complexity is O(\log_{10}(n))
   // Space complexity : O(1)
    private static boolean isPalindrome(int x) {
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || x % 10 == 0 && x != 0) return false;

        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
            System.out.println("reverseNumber: " + reverseNumber + " number: " + x);
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == reverseNumber || x == reverseNumber / 10;
    }

    //my solution
    private static boolean isPalindromeMy(int x) {
        if (x < 0) return false;
        int i = x;
        int reverse = 0;

        while (i != 0) {
            int result = reverse * 10 + i % 10;
            if (result / 10 != reverse) return false;
            reverse = result;
            i /= 10;
        }

        System.out.println(reverse);
        return reverse == x;
    }
}

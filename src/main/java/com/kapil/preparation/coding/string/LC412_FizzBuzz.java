package com.kapil.preparation.coding.string;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz".
 * For numbers which are multiples of both three and five print "FizzBuzz". The solution should be *recursive*.
 *
 * https://leetcode.com/problems/fizz-buzz/
 *  * */
public class LC412_FizzBuzz {
    public static void main(String[] args) {
//        fizzBuzz();

//        System.out.println(fizzBuzzRecursive(100));
        System.out.println(fizzBuzzRecursiveSB(100));
//        System.out.println(fizzBuzzRecursiveAlt(100));
//        System.out.println(fizzBuzz(25));
//        fizzBuzzJava8();
    }

    private static List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> i % 15 != 0 ? i % 5 != 0 ? i % 3 != 0  ? String.valueOf(i) : "Fizz" : "Buzz": "FizzBuzz")
                .collect(Collectors.toList());
    }



    private static void fizzBuzzJava8() {
        IntStream.range(1, 100)
//                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .mapToObj(i -> i % 15 != 0 ? i % 5 != 0 ? i % 3 != 0 ? i : "Fizz" : "Buzz" : "FizzBuzz")
                .forEach(System.out::println);
    }

    private static String fizzBuzzRecursive(int num) {
        String str = "";

        if (num == 0)
            return str;
        if (num % 3 == 0)
            str += "Fizz";
        if (num % 5 == 0)
            str += "Buzz";
        if (str.isBlank())
            str += num;

        return fizzBuzzRecursive(num - 1) + str + "\n";
    }

    private static String fizzBuzzRecursiveSB(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0)
            return sb.toString();

        if (num % 3 == 0)
            sb.append("Fizz");

        if (num % 5 == 0)
            sb.append("Buzz");

        if (sb.toString().isBlank())
            sb.append(num);

        return fizzBuzzRecursiveSB(num - 1) + sb.append("\n");
    }

    private static String fizzBuzzRecursiveAlt(int num) {
        return num > 0 ?
                fizzBuzzRecursiveAlt(num - 1) + (num % 15 != 0 ? num % 5 != 0 ? num % 3 != 0 ? (num + "\n") : "Fizz\n" : "Buzz\n" : "FizzBuzz\n")
                : "";
    }

    private static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            // if(multi 3) print fizz
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
                continue;
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
                continue;
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
                continue;
            } else {
                System.out.println(i);
            }
        }
    }
}

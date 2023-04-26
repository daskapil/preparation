package com.kapil.preparation.java8.streamapi;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 10, 2, 2);

        //R reduce(T identity, BinaryOperator<T> accumulator)
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum using reduce(identity, BinaryOperator<T> accumulator): " + sum2);

        int sumUsingStreamSumMethod = numbers.stream().mapToInt(i-> i).sum();
        System.out.println("Sum using Stream sum(): " + sumUsingStreamSumMethod);

        //Optional<R> reduce(BinaryOperator<T> accumulator)
        int maxUsingMethodRef = numbers.stream().reduce(Integer::max).get();
        System.out.println("max Using Method Ref: " + maxUsingMethodRef);

        double avg = numbers.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println("Average: " + avg);

        List<String> words = List.of("Raj", "Anita", " Sumana", "Kohi", "Jordona");
        getLongestWord(words);
        getLongestWord();
    }

    private static void getLongestWord(List<String> words) {
        String longestWord = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
//                .get();
                .orElse("no word found!");
        System.out.println("Longest word: " + longestWord);
    }

    private static void getLongestWord() {
        String sentence = "I love you India";
        String longestWord = Arrays.stream(sentence.trim().split(" "))
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1: w2)
                .orElse("No such word found");

        System.out.println(longestWord);
    }

}

package com.kapil.preparation.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseObject {

    public static void main(String[] args) {
        String s = "Kapil";
//        System.out.println("reverseString(s): " + reverseStringLoop(s));
        System.out.println("reverseString(s): " + reverseStringStreamAPI(s));
//        System.out.println("reverseStringStringBuilder(s): " + reverseStringStringBuilder(s));
//
        Object[] array = new String[]{"apples", "tomatoes", "bananas", "guavas", "pineapples"};
//        reverseArrayLoop(array);
        reverseArrayStreamAPI(array);
//        reverseCollections(array);
    }

    private static String reverseStringLoop(String input) {
        if (input == null) return input;

        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    private static String reverseStringStringBuilder(String input) {
        if (input == null) return input;

        return new StringBuilder(input).reverse().toString();
    }

    private static void reverseArrayLoop(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(array));
    }

    private static void reverseArrayStreamAPI(Object[] array) {
        Object[] reversedArray = IntStream.range(0, array.length).mapToObj(i -> array[array.length - i - 1]).toArray();
        System.out.println(Arrays.toString(reversedArray));
    }

    private static String reverseStringStreamAPI(String s) {
        return Stream.of(s.split(""))
                .reduce("", (reversed, character) -> character + reversed);
    }

    private static void reverseCollections(Object[] array) {
        List<Object> list = Arrays.asList(array);
        Collections.reverse(list);
        System.out.println(list);
    }
}

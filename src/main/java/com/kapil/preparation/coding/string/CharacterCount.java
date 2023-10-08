package com.kapil.preparation.coding.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterCount {

    /*
     * Text = "bookkeeper"
     * output = { b=1,o=2,k=2,e=3,p=1,r=1}
     *
     * Company: Lowe's
     * */
    public static void main(String[] args) {
        String text = "bookkeeper";
        System.out.println(countCharacters(text));
        System.out.println(countCharacters2(text));
    }

    private static Map<Character, Integer> countCharacters(String text) {
        Map<Character, Integer> outputs =  new TreeMap<>();
        for (char c: text.toCharArray()) {
            if (outputs.containsKey(c)){
                outputs.put(c, outputs.get(c) + 1);
            } else {
                outputs.put(c, 1);
            }
        }
        return outputs;
    }

    private static Map<Character, Integer> countCharacters2(String text) {
        Map<Character, Integer> outputs =  new TreeMap<>();
        for (char c: text.toCharArray()) {
            outputs.put(c, outputs.getOrDefault(c, 0) + 1);
        }
        return outputs;
    }
}

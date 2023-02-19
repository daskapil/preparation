package com.kapil.preparation.coding.array;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/most-common-word/
 * Easy
 * */
public class LC819_MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
        System.out.println(mostCommonWord_2(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase()
                .replaceAll("[^a-zA-Z0-9 ]+", " ")
                .split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        System.out.println(map);
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static String mostCommonWord_2(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase()
                .replaceAll("[^a-zA-Z0-9 ]+", " ")
                .split("\\s+");

        Map<String, Integer> map = Arrays.stream(words)
                .filter(s -> !set.contains(s))
                .collect(Collectors.toMap(s -> s, s -> 1, (f, l) -> f + 1));

        System.out.println(map);
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

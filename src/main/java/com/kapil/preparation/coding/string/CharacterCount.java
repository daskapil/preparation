package com.kapil.preparation.coding.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static class LC46_Permutations {

        public static void main(String[] args) {

        }

        private static List<List<Integer>> permute(int[] nums) {
            List<Integer> in = IntStream.range(0, nums.length).boxed().collect(Collectors.toList());
            return permute(in, new ArrayList<>());
        }

        private static List<List<Integer>> permute(List<Integer> in, List<Integer> out) {
            List<List<Integer>> list = new ArrayList<>();

            if (in.isEmpty()) {
                list.add(out);
                return list;
            }

            int n = in.get(0);
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i <= out.size(); i++) {

            }

            return list;
        }
    }
}

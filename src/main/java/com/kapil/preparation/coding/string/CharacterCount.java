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

//        Map<Character, Integer> output = new HashMap<>(); --> Use HashMap for unsorted output
        Map<Character, Integer> output = new TreeMap<>(); // --> Use TreeMap for sorted output

        for (char c : text.toCharArray()) {
            if (output.containsKey(c)) {
                output.put(c, output.get(c) + 1);
            } else {
                output.put(c, 1);
            }
        }

        System.out.println(output);
    }

    public static class LC46_Permutations {

        public static void main(String[] args) {

        }

        private static List<List<Integer>> permute(int[] nums) {
            List<Integer> in = IntStream.range(0, nums.length).boxed().collect(Collectors.toList());
            return permute(in, new ArrayList<>());
        }

        private static List<List<Integer>> permute(List<Integer>in, List<Integer> out) {
            List<List<Integer>> list = new ArrayList<>();

            if(in.isEmpty()){
                list.add(out);
                return list;
            }

            int n = in.get(0);
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i <=out.size(); i++){

            }

            return list;
        }
    }
}

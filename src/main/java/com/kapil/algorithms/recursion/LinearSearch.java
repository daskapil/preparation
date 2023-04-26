package com.kapil.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 11, 11, 6, 7, 10, 12, 11, 11};
        int target = 11;
        System.out.println(search(arr, target));
        System.out.println(findAllIndex(arr, target));
    }

    static int search(int[] arr, int target) {
        return search(arr, target, 0);
    }

    static int search(int[] arr, int target, int index) {
        if (index == arr.length) return -1;
        return target == arr[index] ? index : search(arr, target, index + 1);
    }

    static List<Integer> findAllIndex(int[] arr, int target) {
        return findAllIndex(arr, target, 0);
    }

    private static List<Integer> findAllIndex(int[] arr, int target, int i) {
        List<Integer> list = new ArrayList<>();

        if (i == arr.length) return list;

        if (target == arr[i]) list.add(i);
        list.addAll(findAllIndex(arr, target, i + 1));
        return list;
    }

}

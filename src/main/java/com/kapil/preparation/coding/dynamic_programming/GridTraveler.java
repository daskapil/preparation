package com.kapil.preparation.coding.dynamic_programming;

/*
 * Say that you are a traveler  on a grid. YOu begin in the top-left corner and your goal is to
 * travel to the bottom-right corner.YOu may only move down or right.
 *
 * In how many ways can you travel to the goal on a grid with dimensions m * n?
 *
 * Write a function 'gridTraveler(m, n)' that calculate this.
 * */

import java.util.HashMap;

public class GridTraveler {
    public static void main(String[] args) {
        int m = 18;
        int n = 18;
        System.out.println(gridTraveler(m, n));
    }

    private static long gridTraveler(int m, int n) {
        return gridTraveler(m, n, new HashMap<>());
    }

    private static long gridTraveler(int m, int n, HashMap<String, Long> memo) {
        String key = m + "," + n;

        if (memo.containsKey(key)) return memo.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;

        memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
        return memo.get(key);
    }
}

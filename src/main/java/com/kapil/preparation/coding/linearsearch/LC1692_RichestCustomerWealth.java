package com.kapil.preparation.coding.linearsearch;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/richest-customer-wealth/
 * */
public class LC1692_RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};

        System.out.println("Richest person: " + maximumWealth(accounts));
    }

    // Approach 1
    public static int maximumWealth(int[][] accounts) {
        int wealth = Integer.MIN_VALUE;

        for (int row = 0; row < accounts.length; row++) {
            int total = Arrays.stream(accounts[row]).sum();
            if (wealth < total) {
                wealth = total;
            }
        }

        return wealth;
    }

    // Approach 2
    public static int maximumWealth2(int[][] accounts) {
        int persons = accounts.length;
        int[] totals = new int[persons];

        for (int row = 0; row < persons; row++) {
            totals[row] = Arrays.stream(accounts[row]).sum();
        }
        IntSummaryStatistics statistics = Arrays.stream(totals).summaryStatistics();
        System.out.println(statistics);
        return statistics.getMax();
    }
}

package com.kapil.learn.concurrency.mergesortexecutor;

import com.kapil.algorithms.recursion.SortedArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) return arrayToSort;

        int n = arrayToSort.size();
        int mid = n / 2;

        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }

        Future<List<Integer>> leftSortedFuture = this.executorService.submit(new Sorter(leftArray, executorService));

        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        Future<List<Integer>> rightSortedFuture = this.executorService.submit(new Sorter(rightArray, executorService));

        List<Integer> leftSortedArray = leftSortedFuture.get();
        List<Integer> rightSortedArray = rightSortedFuture.get();

        List<Integer> sortedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) < rightSortedArray.get(i)) {
                sortedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }

            while (i < leftSortedArray.size()) {
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }

            while (j < rightSortedArray.size()) {
                sortedArray.add(rightSortedArray.get(j));
                i++;
            }
        }
        return sortedArray;
    }
}

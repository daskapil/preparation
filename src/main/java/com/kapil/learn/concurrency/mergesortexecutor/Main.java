package com.kapil.learn.concurrency.mergesortexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> nums = List.of(10, 5, 8, 4, 1, 6, 13, 27);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future<List<Integer>> sortedFuture = executorService.submit(new Sorter(nums, executorService));
        List<Integer> sortedArray = sortedFuture.get();
        System.out.println(sortedArray.toString());
    }
}

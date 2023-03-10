package com.kapil.learn.concurrency.squarenumbercallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            Future<Integer> value = executorService.submit(new SquareCalculator(i));
        }
    }
}

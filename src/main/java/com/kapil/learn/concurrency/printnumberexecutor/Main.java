package com.kapil.learn.concurrency.printnumberexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println(" Start Printing Number");

        for (int i = 1; i < 100; i++) {
            executorService.execute(new NumberPrinter(i));
            // executorService.submit(new NumberPrinter(i));

            if (i == 40) {
                System.out.println("Just messing around");
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Bye Everyone --> " + Thread.currentThread().getName());
    }
}

package com.kapil.learn.concurrency.squarenumbercallable;

import java.util.concurrent.Callable;

public class SquareCalculator implements Callable<Integer> {
    private int numberTpCalculate;

    public SquareCalculator(int numberTpCalculate) {
        this.numberTpCalculate = numberTpCalculate;
    }

    @Override
    public Integer call() throws Exception {
        return numberTpCalculate * numberTpCalculate;
    }
}

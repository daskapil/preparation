package com.kapil.learn.concurrency.printnumbers;

public class NumberPrinter implements  Runnable{
    private int numberToPrint;
    public NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " --> " + Thread.currentThread().getName());
    }
}

package com.kapil.learn.concurrency.printnumbers;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Start Print Number");
        for (int i = 1; i < 100; i++) {
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }
    }
}

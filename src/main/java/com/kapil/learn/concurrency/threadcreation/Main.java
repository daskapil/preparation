package com.kapil.learn.concurrency.threadcreation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! -->  " + Thread.currentThread().getName());

        Thread t = new Thread(new HelloKapil());
        t.start();

        System.out.println("Bye Everyone --> " + Thread.currentThread().getName());
    }
}

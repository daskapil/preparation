package com.kapil.learn.concurrency.threadcreation;

public class HelloKapil implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Kapil! -> " + Thread.currentThread().getName());
    }
}

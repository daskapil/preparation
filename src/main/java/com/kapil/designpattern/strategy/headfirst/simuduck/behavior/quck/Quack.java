package com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck;

public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("This duck says QUACK");
    }
}

package com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("This Duck does not quack. MUTE!");
    }
}

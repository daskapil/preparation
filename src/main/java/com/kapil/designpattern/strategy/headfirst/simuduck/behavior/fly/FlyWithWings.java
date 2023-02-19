package com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I fly with wings!");
    }
}

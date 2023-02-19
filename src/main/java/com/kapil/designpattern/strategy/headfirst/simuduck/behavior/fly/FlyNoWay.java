package com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("THis duck does not fly!");
    }
}

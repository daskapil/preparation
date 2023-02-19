package com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with Rocket");
    }
}

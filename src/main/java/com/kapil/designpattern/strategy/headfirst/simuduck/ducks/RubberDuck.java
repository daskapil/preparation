package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyNoWay;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        System.out.println("I am Rubber Duck!");
    }
}

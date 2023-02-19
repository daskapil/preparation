package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyWithWings;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.Quack;

public class RedheadDuck extends Duck{
    public RedheadDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I am a Red Head duck!");
    }
}

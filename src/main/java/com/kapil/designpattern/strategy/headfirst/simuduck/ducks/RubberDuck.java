package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyNoWay;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.Squeak;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        log.info("I am Rubber Duck!");
    }
}

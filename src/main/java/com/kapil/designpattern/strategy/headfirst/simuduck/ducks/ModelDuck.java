package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyNoWay;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.Quack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModelDuck extends Duck {
    public ModelDuck() {
        super(new FlyNoWay(), new Quack());
    }

    @Override
    public void display() {
        log.info("I am a Model Duck");
    }
}

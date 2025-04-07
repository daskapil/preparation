package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyWithWings;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.Quack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedheadDuck extends Duck{
    public RedheadDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        log.info("I am a Red Head duck!");
    }
}

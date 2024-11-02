package com.kapil.designpattern.strategy.headfirst.simuduck.ducks;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyBehavior;
import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.quck.QuackBehavior;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    protected Duck() {
    }

    protected Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void swim(){
        log.info("All ducks float and even decoys");
    }

    public abstract void display();

}

package com.kapil.designpattern.strategy.headfirst.simuduck;

import com.kapil.designpattern.strategy.headfirst.simuduck.behavior.fly.FlyRocketPowered;
import com.kapil.designpattern.strategy.headfirst.simuduck.ducks.Duck;
import com.kapil.designpattern.strategy.headfirst.simuduck.ducks.MallardDuck;
import com.kapil.designpattern.strategy.headfirst.simuduck.ducks.ModelDuck;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
        duck.swim();

        Duck model = new ModelDuck();
        model.display();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }
}

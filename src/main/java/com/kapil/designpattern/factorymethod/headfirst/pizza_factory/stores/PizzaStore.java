package com.kapil.designpattern.factorymethod.headfirst.pizza_factory.stores;

import com.kapil.designpattern.factorymethod.headfirst.pizza_factory.factory.SimplePizzaFactory;
import com.kapil.designpattern.factorymethod.headfirst.pizza_factory.pizzas.Pizza;

public abstract class PizzaStore {
//    SimplePizzaFactory factory;
//
//        public PizzaStore(SimplePizzaFactory factory) {
//        this.factory = factory;
//    }
    abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

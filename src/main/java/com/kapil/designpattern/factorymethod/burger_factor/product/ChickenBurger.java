package com.kapil.designpattern.factorymethod.burger_factor.product;

public class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Prepare Chicken burger!");
    }
}

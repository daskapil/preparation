package com.kapil.designpattern.factorymethod.burger_factor.product;

public class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Prepare Veggie burger!");
    }
}

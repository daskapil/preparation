package com.kapil.designpattern.factorymethod.burger_factor.factory;

import com.kapil.designpattern.factorymethod.burger_factor.product.Burger;

public abstract class BurgerFactory {
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}

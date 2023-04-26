package com.kapil.designpattern.factorymethod.burger_factor.factory;

import com.kapil.designpattern.factorymethod.burger_factor.product.Burger;
import com.kapil.designpattern.factorymethod.burger_factor.product.ChickenBurger;

public class ChickenBurgerFactory extends BurgerFactory{
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}

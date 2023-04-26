package com.kapil.designpattern.factorymethod.burger_factor.factory;

import com.kapil.designpattern.factorymethod.burger_factor.product.Burger;
import com.kapil.designpattern.factorymethod.burger_factor.product.ChickenBurger;
import com.kapil.designpattern.factorymethod.burger_factor.product.VeggieBurger;

public class VaggieBurgerFactory extends BurgerFactory{
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}

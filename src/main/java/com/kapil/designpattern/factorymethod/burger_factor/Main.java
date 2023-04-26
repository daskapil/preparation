package com.kapil.designpattern.factorymethod.burger_factor;

import com.kapil.designpattern.factorymethod.burger_factor.factory.BurgerFactory;
import com.kapil.designpattern.factorymethod.burger_factor.factory.ChickenBurgerFactory;
import com.kapil.designpattern.factorymethod.burger_factor.factory.VaggieBurgerFactory;
import com.kapil.designpattern.factorymethod.burger_factor.product.Burger;

public class Main {
    BurgerFactory chickenBurgerFactory = new ChickenBurgerFactory();
    Burger chickenBurger = chickenBurgerFactory.orderBurger();

    BurgerFactory veggiBurgerFactory = new VaggieBurgerFactory();
    Burger veggieBurger = veggiBurgerFactory.orderBurger();
}

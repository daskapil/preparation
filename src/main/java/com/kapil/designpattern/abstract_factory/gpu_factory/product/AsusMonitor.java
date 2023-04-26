package com.kapil.designpattern.abstract_factory.gpu_factory.product;

public class AsusMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("Assemble Asus Monitor");
    }
}

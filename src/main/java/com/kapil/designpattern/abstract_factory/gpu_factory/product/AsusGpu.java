package com.kapil.designpattern.abstract_factory.gpu_factory.product;

public class AsusGpu implements Gpu{
    @Override
    public void assemble() {
        System.out.println("Assemble ASUS GPU!");
    }
}

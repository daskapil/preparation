package com.kapil.designpattern.abstract_factory.gpu_factory.product;

public class MsiGpu implements Gpu{
    @Override
    public void assemble() {
        System.out.println("Assemble MSI GPU!");
    }
}

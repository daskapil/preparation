package com.kapil.designpattern.abstract_factory.gpu_factory;

import com.kapil.designpattern.abstract_factory.gpu_factory.factory.AbstractFactory;
import com.kapil.designpattern.abstract_factory.gpu_factory.factory.AsusFactory;
import com.kapil.designpattern.abstract_factory.gpu_factory.factory.MsiFactory;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Gpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Monitor;

public class Main {
    public static void main(String[] args) {
        AbstractFactory msi = new MsiFactory();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        AbstractFactory asus = new AsusFactory();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();
    }
}

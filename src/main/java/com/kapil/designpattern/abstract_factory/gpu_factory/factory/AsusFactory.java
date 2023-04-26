package com.kapil.designpattern.abstract_factory.gpu_factory.factory;

import com.kapil.designpattern.abstract_factory.gpu_factory.product.AsusGpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.AsusMonitor;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Gpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Monitor;

public class AsusFactory extends AbstractFactory {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}

package com.kapil.designpattern.abstract_factory.gpu_factory.factory;

import com.kapil.designpattern.abstract_factory.gpu_factory.product.Gpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Monitor;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.MsiGpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.MsiMonitor;

public class MsiFactory extends AbstractFactory {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

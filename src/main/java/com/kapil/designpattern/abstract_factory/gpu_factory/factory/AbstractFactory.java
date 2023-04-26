package com.kapil.designpattern.abstract_factory.gpu_factory.factory;

import com.kapil.designpattern.abstract_factory.gpu_factory.product.Gpu;
import com.kapil.designpattern.abstract_factory.gpu_factory.product.Monitor;

public abstract class AbstractFactory {

    //Business logic can be added here

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();
}

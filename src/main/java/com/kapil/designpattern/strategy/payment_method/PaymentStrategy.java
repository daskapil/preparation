package com.kapil.designpattern.strategy.payment_method;

public interface PaymentStrategy {
    void collectPaymentDetails();
    boolean validatePaymentDetails();
    void pay (int amount);
}

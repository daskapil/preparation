package com.kapil.designpattern.strategy.payment_method;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new PaymentByCreditCard());
        paymentService.processOrder();
    }
}

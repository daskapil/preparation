package com.kapil.designpattern.strategy.payment_method;

public class PaymentByPayPal implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void collectPaymentDetails() {
        // Pop-up to PayPay credentials details
        email = "...";
        password = "...";
    }

    @Override
    public boolean validatePaymentDetails() {
        //Validating Paypal account...
        return false;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Paypal");
    }
}

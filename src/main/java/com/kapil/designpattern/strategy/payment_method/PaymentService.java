package com.kapil.designpattern.strategy.payment_method;

public class PaymentService {
    private int cost;
    private boolean includeDelivery;
    private PaymentStrategy paymentStrategy;

    public void processOrder() {
        paymentStrategy.collectPaymentDetails();
        if(paymentStrategy.validatePaymentDetails()){
            paymentStrategy.pay(getTotal());
        }
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }
}

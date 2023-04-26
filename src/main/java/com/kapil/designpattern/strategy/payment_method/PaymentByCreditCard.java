package com.kapil.designpattern.strategy.payment_method;

import java.time.LocalDate;
import java.util.Date;

public class PaymentByCreditCard implements PaymentStrategy {
    private CreditCard creditCard;

    @Override
    public void collectPaymentDetails() {
        // Pop-up to collect card details
        long cardNumber = 1234455;
        LocalDate expiryDate = LocalDate.now();
        creditCard = new CreditCard(cardNumber, expiryDate, 123);
    }

    @Override
    public boolean validatePaymentDetails() {
        //Validating Credit card details
        return false;
    }

    @Override
    public void pay(int amount) {
        creditCard.setAmount(creditCard.getAmount() - amount);
    }
}

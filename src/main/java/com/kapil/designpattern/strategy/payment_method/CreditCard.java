package com.kapil.designpattern.strategy.payment_method;

import java.time.LocalDate;
import java.util.Date;

public class CreditCard {
    private long creditCardNumber;
    private LocalDate expiryDate;
    private int cvv;

    private long amount;

    public CreditCard(long creditCardNumber, LocalDate expiryDate, int cvv) {
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

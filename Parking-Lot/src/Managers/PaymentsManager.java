package Managers;

import Payments.PaymentStrategy;

public class PaymentsManager {

    public PaymentsManager(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    PaymentStrategy paymentStrategy;

    public void chargeAmount(double amount){
        paymentStrategy.pay(amount);
    }

}

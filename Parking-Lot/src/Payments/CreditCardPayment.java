package Payments;

import java.util.Date;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Amount : " + amount + " has been debited from Credit Card.." );
    }
}

package Services;

import Services.payments.Card;
import Services.payments.Payment;
import Services.payments.PaymentType;
import Services.payments.UPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentService {

    public List<PaymentType> paymentTypes;

    public PaymentService(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public void processPayment(double amount){

        System.out.println("******************** Please select the Payment mode *****************************");

        for(int i=0;i<paymentTypes.size();i++){
            System.out.println((i+1) + " : " + paymentTypes.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int paymentMode = scanner.nextInt()-1;

        Payment payment;

        switch (paymentTypes.get(paymentMode)){
            case UPI -> payment = new UPI();
            case CARD -> payment = new Card();
            default -> throw new IllegalStateException("Unexpected value: " + paymentTypes.get(paymentMode));
        }

        payment.pay(amount);

    }

}

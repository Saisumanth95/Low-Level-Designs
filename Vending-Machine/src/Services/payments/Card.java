package Services.payments;

public class Card implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid amount : " + amount + " using Card");
    }
}

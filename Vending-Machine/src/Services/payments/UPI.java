package Services.payments;

public class UPI implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid amount : " + amount + " using UPI");
    }
}

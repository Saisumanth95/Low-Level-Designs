package Transactions;

public class ShowBalance implements Transaction{

    @Override
    public void performTransaction(TransactionContext context) {
        double balance = context.getBankService().getBalance(context.getAccountNumber());
        System.out.println("Current Balance: " + balance);
    }
}

package Transactions;

public class DepositTransaction implements Transaction{
    @Override
    public void performTransaction(TransactionContext context) {
        context.getBankService().deposit(context.getAccountNumber(), context.getAmount());
        System.out.println("Deposit successful: " + context.getAmount());
    }
}

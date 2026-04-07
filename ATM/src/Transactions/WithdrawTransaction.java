package Transactions;

public class WithdrawTransaction implements Transaction{
    @Override
    public void performTransaction(TransactionContext context) {
        context.getBankService().withdraw(context.getAccountNumber(), context.getAmount());
        System.out.println("Withdraw successful: " + context.getAmount());
    }
}

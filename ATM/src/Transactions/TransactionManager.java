package Transactions;

public class TransactionManager {

    public Transaction createTransaction(TransactionType transactionType) throws IllegalAccessException {

        switch (transactionType){
            case WITHDRAW -> {
                return new WithdrawTransaction();
            }

            case DEPOSIT -> {
                return new DepositTransaction();
            }

            case SHOW_BALANCE -> {
                return new ShowBalance();
            }

            default -> throw new IllegalAccessException("Invalid Transaction");
        }

    }

}

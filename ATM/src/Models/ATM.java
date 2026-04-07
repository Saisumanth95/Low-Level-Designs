package Models;

import Transactions.Transaction;
import Transactions.TransactionContext;
import Transactions.TransactionManager;
import Transactions.TransactionType;

public class ATM {

    private Session currentSession;
    private BankService bankService;
    private TransactionManager transactionManager;

    public ATM(BankService bankService) {
        this.transactionManager = new TransactionManager();
        this.bankService = bankService;
    }

    public void insertCard(Card card){
        currentSession = Session.createSession(card);
        System.out.println("Card inserted!");
    }

    public void pinEntry(String pin){
        String accountNumber = bankService.authenticate(currentSession.getCard(), pin);
        currentSession.authenticate(accountNumber);
        System.out.println("Authentication Successful!");
    }

    public void executeTransaction(TransactionType transactionType, Double amount) throws Exception {

        if(!currentSession.isAuthenticated()){
            throw new Exception("User is not Authenticated..");
        }

        try {
            Transaction transaction = transactionManager.createTransaction(transactionType);
            TransactionContext transactionContext = new TransactionContext(currentSession.getAccountNumber(),bankService, amount == null ? 0 : amount);
            transaction.performTransaction(transactionContext);

            System.out.println("Transaction Successful!!");

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

   public void ejectCard(){
        currentSession.endSession();
        System.out.println("Card Ejected.....");
    }




}

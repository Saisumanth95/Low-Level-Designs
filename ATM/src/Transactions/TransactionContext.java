package Transactions;

import Models.BankService;

public class TransactionContext {

    private String accountNumber;
    private BankService bankService;
    private double amount;

    public TransactionContext(String accountNumber, BankService bankService, double amount) {
        this.accountNumber = accountNumber;
        this.bankService = bankService;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
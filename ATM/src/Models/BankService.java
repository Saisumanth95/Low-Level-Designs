package Models;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<String, Double> accountNumberBalances;
    private Map<String, String> cardNumberPins;
    private Map<String, String> accountCardMap;

    public BankService(Map<String, Double> accountNumberBalances, Map<String, String> cardNumberPins, Map<String, String> accountCardMap) {
        this.accountNumberBalances = accountNumberBalances;
        this.cardNumberPins = cardNumberPins;
        this.accountCardMap = accountCardMap;
    }

    public String authenticate(Card card, String pin){
        if(pin.equals(cardNumberPins.get(card.getCardNo()))){
            return accountCardMap.get(card.getCardNo());
        }
        return null;
    }

    public boolean deposit(String accountNumber, double amount){
        double currentAmount = accountNumberBalances.get(accountNumber);
        currentAmount += amount;
        accountNumberBalances.put(accountNumber, currentAmount);
        return true;
    }

    public boolean withdraw(String accountNumber, double amount){
        double currentAmount = accountNumberBalances.get(accountNumber);
        if(currentAmount<amount){
            throw new RuntimeException("In sufficient funds");
        }
        currentAmount -= amount;
        accountNumberBalances.put(accountNumber, currentAmount);
        return true;
    }

    public double getBalance(String accountNumber){
        return accountNumberBalances.get(accountNumber);
    }

}

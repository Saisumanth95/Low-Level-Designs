import Models.ATM;
import Models.BankService;
import Models.Card;
import Transactions.TransactionType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


     Map<String, Double> accountNumberBalances = new HashMap<>();
     Map<String, String> cardNumberPins = new HashMap<>();
     Map<String, String> accountCardMap = new HashMap<>();

     accountNumberBalances.put("123", 20.00);
     accountNumberBalances.put("145", 40.00);
     accountNumberBalances.put("789", 80.00);
     cardNumberPins.put("abc", "111");
     cardNumberPins.put("def", "222");
     cardNumberPins.put("ghi", "333");
     accountCardMap.put("abc", "123");
     accountCardMap.put("def", "145");
     accountCardMap.put("ghi", "789");

     Card card1 = new Card("abc", "12/27", "KOTAK");
     Card card2 = new Card("def", "12/27", "ICICI");
     Card card3 = new Card("ghi", "12/27", "HDFC");



    BankService bankService = new BankService(accountNumberBalances, cardNumberPins, accountCardMap);

    ATM atm = new ATM(bankService);

    atm.insertCard(card1);
    atm.pinEntry("111");
    try {
        atm.executeTransaction(TransactionType.DEPOSIT, 1200.00);
        atm.executeTransaction(TransactionType.SHOW_BALANCE, null);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    atm.ejectCard();


    atm.insertCard(card2);
    atm.pinEntry("222");
    try {
        atm.executeTransaction(TransactionType.WITHDRAW, 12.00);
        atm.executeTransaction(TransactionType.SHOW_BALANCE, null);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    atm.ejectCard();


    atm.insertCard(card3);
    atm.pinEntry("333");
    try {
        atm.executeTransaction(TransactionType.SHOW_BALANCE, null);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    atm.ejectCard();


}

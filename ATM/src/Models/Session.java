package Models;

public class Session {

    private Card card;
    private String accountNumber;
    private boolean isAuthenticated;
    private static Session session;

    private Session(Card card) {
       this.card = card;
    }

    public static Session createSession(Card card){
        if(session == null){
            session = new Session(card);
        }
        return session;
    }

    public void endSession(){
        session = null;
    }

    public void authenticate(String accountNumber){
        this.accountNumber = accountNumber;
        this.isAuthenticated = true;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public Card getCard() {
        return card;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

package Models;

public class Card {

    private String cardNo;
    private String expiryDate;
    private String bankId;

    public Card(String cardNo, String expiryDate, String bankId) {
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
        this.bankId = bankId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}

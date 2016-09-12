package edu.eci.cosw.sharepark.entities;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
public class CreditCard {
    public CreditCard() {
    }
    private Integer cardNumber;
    private String expirationDate;
    private Integer cvcCode;

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }
}

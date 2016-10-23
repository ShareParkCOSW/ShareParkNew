package edu.eci.cosw.sharepark.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard {
    public CreditCard() {
    }
    private Integer cardNumber;
    private String expirationDate;
    private Integer cvcCode;
    private Integer owner_id;

    @Column(name = "owner_id")
    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    @Id
    @Column(name = "card_number")
    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Column(name = "expiration_date")
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    @Column(name = "cvc_code")
    public Integer getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }
}

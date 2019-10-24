package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.CreditCard;

/**
 * Created by 2101047 on 10/26/16.
 */
public interface CreditCardsServices {


    public void addCreditCard(CreditCard c);
    public CreditCard getCreditCard(Integer id);
    public void updateCreditCard(CreditCard c);
}

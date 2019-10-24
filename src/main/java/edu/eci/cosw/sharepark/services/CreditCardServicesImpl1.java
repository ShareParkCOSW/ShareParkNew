package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.CreditCard;
import edu.eci.cosw.sharepark.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2101047 on 10/26/16.
 */
public class CreditCardServicesImpl1 implements CreditCardsServices {

    private List<CreditCard> creditCards=new ArrayList<>();

    @java.lang.Override
    public void addCreditCard(CreditCard c) {
        creditCards.add(c);

    }

    @java.lang.Override
    public CreditCard getCreditCard(Integer id) {
        CreditCard ans=null;
        for (CreditCard c: creditCards) {
            if(c.getCardNumber()==id){
                ans=c;
                break;
            }
        }
        return ans;
    }

    @java.lang.Override
    public void updateCreditCard(CreditCard c) {
        for (CreditCard cc:creditCards) {
            if(cc.getCardNumber()==c.getCardNumber()){
                cc=c;
                break;
            }
        }
    }
}

package edu.eci.cosw.sharepark.controller;

import edu.eci.cosw.sharepark.entities.CreditCard;
import edu.eci.cosw.sharepark.services.CreditCardsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2101047 on 10/26/16.
 */
@RestController
@RequestMapping("/tarjetas")
public class CreditCardController {

    @Autowired
    private CreditCardsServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST VEHICULOS FUNCIONA!!";
    }

    @RequestMapping(value = "/{creditcardNumber}", method = RequestMethod.GET)
    public CreditCard getOneCreditCard(@PathVariable("creditcardNumber") Integer creditcardNumber){
        return services.getCreditCard(creditcardNumber);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCreditCard(@RequestBody(required = true)CreditCard c){
        services.addCreditCard(c);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateCreditCard(@RequestBody(required = true)CreditCard c){
        services.addCreditCard(c);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

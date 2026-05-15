package edu.teamrocket.ricksyBusiness.paymentMethods;

import java.util.HashMap;
import java.util.Map;

import edu.teamrocket.ricksyBusiness.services.GuestDispatcher;

public class UfosPark implements GuestDispatcher{
    
    private Integer free;
    private Map<String, String> fleet = new HashMap<>();
    private String ovni;
    private String card;


    public UfosPark(){};

    public void add(String ovni){
        this.fleet.put(ovni, null);
    }




    @Override
    public void dispatch(CreditCard card) {

        card.pay(500);

        
        
    }

}

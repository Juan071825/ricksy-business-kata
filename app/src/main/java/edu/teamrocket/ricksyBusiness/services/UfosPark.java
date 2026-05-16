package edu.teamrocket.ricksyBusiness.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

import edu.teamrocket.ricksyBusiness.paymentMethods.CreditCard;

public class UfosPark implements GuestDispatcher{
    
    private Map<String, String> fleet = new HashMap<>();


    public UfosPark(){};


    public Map<String, String> getFleet(){
        return this.fleet;
    }

    public void add(String ovni){
        getFleet().putIfAbsent(ovni, null);
    }

    @Override
    public void dispatch(CreditCard card) {

        List<String> freeUfos = new ArrayList<>();

        for(Map.Entry<String, String> ufo : getFleet().entrySet()){
            if(ufo.getValue() == null){
                freeUfos.add(ufo.getKey());
            }
        }

        if(freeUfos.size() > 0 && card.credit() >= 500.0 && getUfoOf(card.number()) == null){
            Integer freeUfoIndex = ThreadLocalRandom.current().nextInt(0, freeUfos.size());
            getFleet().replace(freeUfos.get(freeUfoIndex), null, card.number());
            card.pay(500.0);
        }
    }

    public String getUfoOf(String number){
        for(Map.Entry<String, String> ufo : getFleet().entrySet()){
            if(number.equals(ufo.getValue())){
                return ufo.getKey();
            }
        }
        return null;
    }


    public String toString() {

        StringBuilder ufosPark = new StringBuilder();
        ufosPark.append("Listado de ufos y usuarios que los están utilizando\n");
        getFleet().forEach((ufo, usuario) ->
            ufosPark.append("ufo: ")
                    .append(ufo)
                    .append("   usuario: ")
                    .append(usuario)
                    .append("\n")
        );
        
        return ufosPark.toString();
    }


}

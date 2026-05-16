package edu.teamrocket.ricksyBusiness.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

import edu.teamrocket.ricksyBusiness.paymentMethods.CreditCard;

public class UfosPark implements GuestDispatcher{
    
    private Integer free;
    private Map<String, String> fleet = new HashMap<>();
    private String ovni;
    private String card;


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

        if(freeUfos.size() > 0 && card.pay(500) == true){
            Integer freeUfoIndex = ThreadLocalRandom.current().nextInt(0, freeUfos.size());
            getFleet().replace(getFleet().get(freeUfos.get(freeUfoIndex)), null, card.owner());
        }
    }

    public String getUfoOf(String name){
        for(Map.Entry<String, String> ufo : getFleet().entrySet()){
            if(ufo.getValue() == name){
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

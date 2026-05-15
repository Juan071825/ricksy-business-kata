package edu.teamrocket.ricksyBusiness.receptivo;

import edu.teamrocket.ricksyBusiness.services.CrystalExpender;
import edu.teamrocket.ricksyBusiness.services.GuestDispatcher;
import edu.teamrocket.ricksyBusiness.services.UfosPark;
import edu.teamrocket.ricksyBusiness.paymentMethods.*;

public class Receptivo {
    
    private static Receptivo instance;
    private UfosPark ufosPark;
    private CrystalExpender crystalExpender;

    public Receptivo(){
        this.getInstance();
    };

    private Receptivo getInstance(){

        if(instance == null){
            instance = new Receptivo();
        }
        return instance;
    }

    public void registra(GuestDispatcher guestDispatcher){
        if(guestDispatcher instanceof CrystalExpender){
            crystalExpender = (CrystalExpender)guestDispatcher;
        } else {
            ufosPark = (UfosPark)guestDispatcher;
        }
    }

    public void dispatch(CreditCard card){
        crystalExpender.dispatch(card);
        ufosPark.dispatch(card);
    }

}

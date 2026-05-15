package edu.teamrocket.ricksyBusiness.receptivo;

public class Receptivo {
    
    private static Receptivo instance;

    private Receptivo(){
        this.getInstance();
    };

    public Receptivo getInstance(){

        if(instance == null){
            instance = new Receptivo();
        }
        return instance;
    }



}

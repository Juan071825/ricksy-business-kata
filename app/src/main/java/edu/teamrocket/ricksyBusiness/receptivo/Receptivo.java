package edu.teamrocket.ricksyBusiness.receptivo;

public class Receptivo {
    
    private static Receptivo instance;

    public Receptivo(){
        this.getInstance();
    };

    private Receptivo getInstance(){

        if(instance == null){
            instance = new Receptivo();
        }
        return instance;
    }



}

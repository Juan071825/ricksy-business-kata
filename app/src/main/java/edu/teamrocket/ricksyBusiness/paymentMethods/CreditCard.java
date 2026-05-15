package edu.teamrocket.ricksyBusiness.paymentMethods;


public class CreditCard {


    private final String owner;
    private final String number;

    
    public CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
    }

    public String number(){
        return this.number;
    }

    public String owner(){
        return this.owner;
    }

    public String toString(){
        StringBuilder card = new StringBuilder();
        card.append("El propietario de esta tarjeta es ");
        card.append(owner());
        card.append(" el id de la tarjeta es ");
        card.append(number());
        return card.toString();
    }

}
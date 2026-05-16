package edu.teamrocket.ricksyBusiness.paymentMethods;


public class CreditCard implements PaymentMethod {


    private final String owner;
    private final String number;
    private Double credit = 3000.0;

    
    public CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
    }

    @Override
    public String number(){
        return this.number;
    }

    @Override
    public String owner(){
        return this.owner;
    }

    @Override
    public Double credit(){
        return this.credit;
    }

    public Boolean pay(Double cost){
        if(credit - cost >= 0){
            this.credit -=  cost;
            return true;
        }
        return false;
    }

    public Boolean pay(Integer cost){
        if(credit() - cost >= 0){
            this.credit -=  cost;
            return true;
        }
        return false;
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
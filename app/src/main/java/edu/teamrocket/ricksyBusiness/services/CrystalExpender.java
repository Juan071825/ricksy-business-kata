package edu.teamrocket.ricksyBusiness.services;

import edu.teamrocket.ricksyBusiness.paymentMethods.CreditCard;

public class CrystalExpender implements GuestDispatcher {
    

    private Integer stock;
    private Integer itemCost;


    public CrystalExpender(Integer stock, Integer itemCost){
        this.stock = stock;
        this.itemCost = itemCost;
    }


    public Integer stock(){
        return this.stock;
    }

    public Integer itemCost(){
        return this.itemCost;
    }

    public void setStock(Integer unidades){
        this.stock = this.stock - unidades;
    }

    @Override
    public void dispatch(CreditCard card) {
        if(stock() > 0 && card.credit() >= itemCost()){
            card.pay(this.itemCost());
            this.setStock(1);
        }
    }

    public String toString(){
        StringBuilder expender = new StringBuilder();
        expender.append("Quedan ");
        expender.append(stock());
        expender.append(" cristales, a un precio por unidad de ");
        expender.append(itemCost());
        return expender.toString();
    }


}

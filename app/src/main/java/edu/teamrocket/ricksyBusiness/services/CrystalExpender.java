package edu.teamrocket.ricksyBusiness.services;

public class CrystalExpender {
    

    private Integer stock;
    private Integer itemCost;


    public CrystalExpender(Integer stock, Integer itemCost){
        this.stock = stock;
        this.itemCost = itemCost;
    }


    public Integer stock(){
        return stock;
    }

    public Integer itemCost(){
        return itemCost;
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

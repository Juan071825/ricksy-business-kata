package edu.teamrocket.ricksyBusiness.services;

public class CrystalExpender {
    

    private Integer stock;
    private Double itemCost;

    public CrystalExpender(Integer stock, Double itemCost){
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public Integer stock(){
        return stock;
    }

    public Double itemCost(){
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

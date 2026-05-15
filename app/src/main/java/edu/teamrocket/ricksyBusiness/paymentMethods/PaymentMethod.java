package edu.teamrocket.ricksyBusiness.paymentMethods;


public interface PaymentMethod {

    public String owner();

    public String number();
    
    public Double credit();
}
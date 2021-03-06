package com.Project0JS.model;

public class Car {
    private int carID;
    private String make;

    private double price = -1.0;

    private int numPaymentsRemaining = 3;

    private String ownerID = "__LOT";

    public Car(String make, int carID) {
        this.make = make;
        this.carID = carID;
    }

    public Car(int carID,String make ,float price,int numPaymentsRemaining,String ownerID) {
        this.make = make;
        this.carID = carID;
        this.price = price;
        this.numPaymentsRemaining = numPaymentsRemaining;
        this.ownerID = ownerID;
    }

    public int getCarID() {
        return carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumPaymentsRemaining() {
        return numPaymentsRemaining;
    }

    public void setNumPaymentsRemaining(int numPaymentsRemaining) {
        this.numPaymentsRemaining = numPaymentsRemaining;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", make='" + make + '\'' +
                ", price=" + price +
                ", numPaymentsMade=" + numPaymentsRemaining +
                ", ownerID='" + ownerID + '\'' +
                '}';
    }
}

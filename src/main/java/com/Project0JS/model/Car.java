package com.Project0JS.model;

public class Car {
    private int carID;
    private String make;

    private double price;

    private static final int numMonthsofPayments = 12;

    private int numPaymentsMade = 0;

    private User owner;

    public Car(String make) {
        this.make = make;
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

    public static int getNumMonthsofPayments() {
        return numMonthsofPayments;
    }

    public int getNumPaymentsMade() {
        return numPaymentsMade;
    }

    public void setNumPaymentsMade(int numPaymentsMade) {
        this.numPaymentsMade = numPaymentsMade;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

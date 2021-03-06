package com.Project0JS.model;

public class Offer {
    private int offer_id;
    private String user_id;
    private int car_id;
    private float price;

    public Offer(int offer_id, String user_id,int car_id, float price) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.car_id = car_id;
        this.price = price;
    }

    public int getOfferId() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", user_id='" + user_id + '\'' +
                ", car_id=" + car_id +
                ", price=" + price +
                '}';
    }
}

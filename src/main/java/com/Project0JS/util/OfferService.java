package com.Project0JS.util;

import com.Project0JS.model.Car;
import com.Project0JS.model.Offer;

public class OfferService {
    private GenericArrayList<Offer> offers = new GenericArrayList<>();

    private static OfferService instance;

    public static OfferService getInstance() {
        if (instance == null) {
            instance = new OfferService();
        }
        return instance;
    }

    private OfferService() {

    }

    public  void rejectOffer(int index) {
        offers.remove(index);
    }

    public  void addOffer(int car_id, String user_id, float price) {
        int open_key = 0;
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getOfferId() == open_key) {
                open_key++;
            }
            if ((offers.get(i).getUser_id().equals(user_id)) && (offers.get(i).getCar_id()==car_id)) {
                offers.get(i).setPrice(price);
                System.out.println("Offer Updated");
                return;
            }
        }
        offers.add(new Offer(open_key, car_id, user_id, price));
        System.out.println("Offer Made");
    }
    public  boolean DoesCarHaveOffer(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getCar_id() == carID) {
                return true;
            }
        }
        return false;
    }
    public  void RemoveOffersOnCar(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getCar_id() == carID) {
                offers.remove(i);
            }
        }
    }
    public  String showAllOffers () {
        if (offers.getIndex() < 1) {
            return "No Offers to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = 0; i < offers.getIndex(); i++) {
            Offer operatedValue = offers.get(i);
            returnbuilder.append("Index :");
            returnbuilder.append(operatedValue.getOfferId());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("User ID: ");
            returnbuilder.append(operatedValue.getUser_id());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("Car ID: ");
            returnbuilder.append(operatedValue.getCar_id());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append( "Make: ");
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append(CarService.getInstance().getCarByID(operatedValue.getCar_id()).getMake());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("Bid : ");
            returnbuilder.append(operatedValue.getPrice());
        }
        return returnbuilder.toString();
    }
    public  boolean isIndexInRange(int index) {
        return index < offers.getIndex();
    }
    public  void acceptOffer(int index) {
        Car car = CarService.getInstance().getCarByID(offers.get(index).getCar_id());
        car.setOwnerID(offers.get(index).getUser_id());
        car.setPrice(offers.get(index).getPrice());
        RemoveOffersOnCar(car.getCarID());
    }

    @Override
    public String toString() {
        return "OfferService{" +
                "offers=" + offers +
                '}';
    }
}

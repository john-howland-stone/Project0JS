package com.Project0JS.util;

import com.Project0JS.model.Car;
import com.Project0JS.model.Offer;

public class OfferService {
    private static GenericArrayList<Offer> offers = new GenericArrayList<Offer>();

    public static void rejectOffer(int index) {
        offers.remove(index);
    }

    public static void addOffer(int index, int user_id, float price) {
        int open_key = 0;
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getOfferId() == open_key) {
                open_key++;
            }
            if ((offers.get(i).getUser_id()==user_id) && (offers.get(i).getCar_id()==CarService.getCarIDbyIndex(index))) {
                System.out.println("You already made an offer on this car");
                return;
            }
        }
        offers.add(new Offer(open_key, CarService.getCarIDbyIndex(index), user_id, price));
    }
    public static boolean DoesCarHaveOffer(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getCar_id() == carID) {
                return true;
            }
        }
        return false;
    }
    public static void RemoveOffersOnCar(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getCar_id() == carID) {
                offers.remove(i);
            }
        }
    }
    public static String showAllOffers () {
        if (offers.getIndex() < 1) {
            return "No Offers to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = 0; i < offers.getIndex(); i++) {
            returnbuilder.append("Index :" + offers.get(i).getOfferId() + "User ID: " + offers.get(i).getUser_id()
                    + "Car ID: " + offers.get(i).getCar_id() + "Make: "
                    + CarService.getCarByID(offers.get(i).getCar_id()).getMake()
                    + "Bid : " + offers.get(i).getPrice());
        }
        return returnbuilder.toString();
    }
    public static boolean isIndexInRange(int index) {
        return index < offers.getIndex();
    }
    public static void acceptOffer(int index) {
        Car car = CarService.getCarByID(offers.get(index).getCar_id());
        car.setOwnerID(offers.get(index).getUser_id());
        car.setPrice(offers.get(index).getPrice());
        RemoveOffersOnCar(car.getCarID());
    }
}

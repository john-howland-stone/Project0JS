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

    public GenericArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(GenericArrayList<Offer> offers) {
        this.offers = offers;
    }

    public void rejectOffer(int index) {
        OfferDao.getInstance().remove(offers.get(index).getOfferId());
        offers.remove(index);
    }

    public void addOffer(int car_id, String user_id, float price) {
        int i;
        for (i = 0; i < offers.getIndex(); i++) {
            Offer existingOffer = offers.get(i);
            if (existingOffer!=null && existingOffer.getUser_id().equals(user_id) && existingOffer.getCar_id() == car_id) {
                existingOffer.setPrice(price);
                OfferDao.getInstance().update(existingOffer);
                System.out.println("Offer Updated");
                return;
            }
        }
        int index = 0;
        i = 0;
        while (i < offers.getIndex()) {
            if (offers.get(i).getOfferId()==index) {
                index++;
                i = 0;
            } else {
                i++;
            }
        }
        Offer addedOffer = new Offer(index, user_id, car_id, price);
        offers.add(addedOffer);
        OfferDao.getInstance().create(addedOffer);

        System.out.println("Offer Made");
    }

    public boolean DoesCarHaveOffer(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            System.out.println(i);
            if (offers.get(i).getCar_id() == carID) {
                return true;
            }
        }
        return false;
    }

    public void RemoveOffersOnCar(int carID) {
        for (int i = 0; i < offers.getIndex(); i++) {
            if (offers.get(i).getCar_id() == carID) {
                offers.remove(i);
                i = 0;
            }
        }
    }

    public String showAllOffers() {
        if (offers.getIndex() < 1) {
            return "No Offers to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = 0; i < offers.getIndex(); i++) {
            Offer operatedValue = offers.get(i);
            returnbuilder.append("Index :");
            returnbuilder.append(i);
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("User ID: ");
            returnbuilder.append(operatedValue.getUser_id());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("Car ID: ");
            returnbuilder.append(operatedValue.getCar_id());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("Make: ");
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append(CarService.getInstance().getCarByID(operatedValue.getCar_id()).getMake());
            returnbuilder.append(System.lineSeparator());
            returnbuilder.append("Bid : ");
            returnbuilder.append(operatedValue.getPrice());
            returnbuilder.append(System.lineSeparator());
        }
        return returnbuilder.toString();
    }

    public boolean doesOfferExistAtIndex(int index) {
        return offers.get(index) !=null;
    }

    public void acceptOffer(int index) {
        Car car = CarService.getInstance().getCarByID(offers.get(index).getCar_id());
        String newowner = offers.get(index).getUser_id();
        car.setOwnerID(newowner);
        car.setPrice(offers.get(index).getPrice());
        OfferDao.getInstance().AcceptOffer(newowner, car.getCarID(),offers.get(index).getPrice());
        RemoveOffersOnCar(car.getCarID());
    }

    @Override
    public String toString() {
        return "OfferService{" +
                "offers=" + offers +
                '}';
    }
}

package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarService {
    private static GenericArrayList<Car> cars = new GenericArrayList<Car>();

    public static void addCar(String make) {
        cars.add(new Car(make));
    }

    public static String showCarsForSale() {
        if (cars.getIndex() == 0) {
            return "No cars for sale";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars for Sale: " + System.lineSeparator());
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getOwnerID() == 0) {
                returnbuilder.append("Index : " + i + " Make: " + cars.get(i).getMake());
            }
        }
        return returnbuilder.toString();
    }

    public static String showCarsWithOffers() {
        if (cars.getIndex() == 0) {
            return "No cars with offers";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars with Offers: " + System.lineSeparator());
        for (int i = 0; i < cars.getIndex(); i++) {
            if (OfferService.DoesCarHaveOffer(cars.get(i).getCarID())) {
                returnbuilder.append("Index : " + i + " Make : " + cars.get(i).getMake());
            }
        }
        return returnbuilder.toString();
    }

    public static String showAllCars() {
        if (cars.getIndex() < 1) {
            return "No Cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = 0; i < cars.getIndex(); i++) {
            returnbuilder.append("Index : " + i + " Make :" + cars.get(i).getMake() + "Has Offers: "
                    + OfferService.DoesCarHaveOffer(cars.get(i).getCarID()) + System.lineSeparator());
        }
        return returnbuilder.toString();
    }

    public static void makeOffer(int index, float price, int userId) {
        if (cars.getIndex() < index) {
            System.out.println("Invalid Car selection");
        } else {
            OfferService.addOffer(cars.get(index).getCarID(), userId, price);
        }
    }

    public static void removeCar(int index) {
        if (index > cars.getIndex()) {
            System.out.println("Invalid Car Index");
        } else {
            cars.remove(index);
        }
    }

    public static boolean isIndexInRange(int index) {
        return index < cars.getIndex();
    }

    public static Car getCarByID(int ID) {
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getCarID() == ID) {
                return cars.get(i);
            }
        }
        return null;
    }

    public static String showCarsbyOwner(int owner) {
        if (cars.getIndex() == 0) {
            return "No cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder("Your cars: " + System.lineSeparator());
        boolean hasCars = false;
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getOwnerID() == owner) {
                returnbuilder.append("Index : " + i + " Make: " + cars.get(i).getMake()
                        + "Payments remaining: " + (Car.getNumMonthsofPayments() - cars.get(i).getNumPaymentsMade())
                        + System.lineSeparator());
                hasCars = true;
            }
        }
        if (hasCars) {
            return returnbuilder.toString();
        } else return "No cars to list";
    }

    public static void MakePaymentbyID(int carID, int userID) {
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getCarID() == carID) {
                if (cars.get(i).getOwnerID() == userID) {
                    if (cars.get(i).getNumPaymentsMade() == Car.getNumMonthsofPayments() - 1) {
                        System.out.println("Payments complete, enjoy your new car ( :");
                        cars.remove(i);
                    }
                    cars.get(i).setNumPaymentsMade(cars.get(i).getNumPaymentsMade() + 1);
                    System.out.println(Car.getNumMonthsofPayments() - cars.get(i).getNumPaymentsMade() + " Payments remaining");
                } else {
                    System.out.println("You are not the owner of the car yo entered");
                }
            }
        }
    }

    public static String showCarswithPayments() {
        if (cars.getIndex() == 0) {
            return "No cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars With Payments: " + System.lineSeparator());
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getOwnerID()!=0) {
                returnbuilder.append("Index : " + i + " Make: " + cars.get(i).getMake()
                        + "Owner : " + cars.get(i).getOwnerID()
                        + " Payments remaining: " + (Car.getNumMonthsofPayments() - cars.get(i).getNumPaymentsMade())
                        + System.lineSeparator());
            }
        }
        return returnbuilder.toString();
    }
    public static double getMonthlyPaymentbyIndex(int index) {
        return cars.get(index).getPrice() / Car.getNumMonthsofPayments();
    }
    public static int getCarIDbyIndex(int index) {
        return cars.get(index).getCarID();
    }
}

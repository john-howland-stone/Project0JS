package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarService {

    private static CarService instance;

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService();
        }
        return instance;
    }

    private CarService() {

    }

    private GenericArrayList<Car> cars = new GenericArrayList<>();

/*    public GenericArrayList<Car> getCars() {
        return cars;
    }*/

    public void setCars(GenericArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(String make) {
        int i;
        for (i = 0; i < cars.getIndex()+1; i++) {
            boolean match = false;
            for (int j = 0; j < cars.getIndex(); j++) {
                if (i == j) {
                    match = true;
                    break;
                }
            }
            if (!match){
                break;
            }
        }
        Car addCar = new Car(make, i);
        cars.add(addCar);
        CarDao.getInstance().create(addCar);
    }

    public String showCarsForSale() {
        boolean carsExistForSale = false;
        for(int i= 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getOwnerID().equals("__LOT")) {
                carsExistForSale=true;
            }
        }
        if (!carsExistForSale) {
            return "No cars for sale";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars for Sale: " + System.lineSeparator());
        for (int i = 0; i < cars.getIndex(); i++) {
            Car operatedValue = cars.get(i);
            if (operatedValue.getOwnerID().equals("__LOT")) {
                returnbuilder.append("Index : ");
                returnbuilder.append(i);
                returnbuilder.append(" Make: ");
                returnbuilder.append(operatedValue.getMake());
                returnbuilder.append(System.lineSeparator());
            }
        }
        return returnbuilder.toString();
    }
/*
    public String showCarsWithOffers() {
        if (cars.getIndex() == 0) {
            return "No cars with offers";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars with Offers: " + System.lineSeparator());
        for (int i = 0; i < cars.getIndex(); i++) {
            if (OfferService.getInstance().DoesCarHaveOffer(cars.get(i).getCarID())) {
                returnbuilder.append("Index : " + i + " Make : " + cars.get(i).getMake());
            }
        }
        return returnbuilder.toString();
    }
 */


    public String showAllCars() {
        if (cars.getIndex() < 1) {
            return "No Cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = 0; i < cars.getIndex(); i++) {
            Car operatedValue = cars.get(i);
            returnbuilder.append("Index : ");
            returnbuilder.append(i) ;
            returnbuilder.append(" Make : ");
            returnbuilder.append(operatedValue.getMake());
            returnbuilder.append(" Owner :");
            returnbuilder.append(operatedValue.getOwnerID());
            returnbuilder.append(" Has Offers: ");
            returnbuilder.append (OfferService.getInstance().DoesCarHaveOffer(operatedValue.getCarID()));
            returnbuilder.append(System.lineSeparator());
        }
        return returnbuilder.toString();
    }

    public void makeOffer(int index, float price, String userName) {
        if (cars.getIndex() < index) {
            System.out.println("Invalid Car selection");
        } else {
            OfferService.getInstance().addOffer(cars.get(index).getCarID(), userName, price);
        }
    }

    public void removeCar(int index) {
        if (index > cars.getIndex()) {
            System.out.println("Invalid Car Index");
        } else {
            OfferDao.getInstance().RemoveOffersOnCar(cars.get(index).getCarID());
            CarDao.getInstance().remove(cars.get(index).getCarID());
            OfferService.getInstance().RemoveOffersOnCar(cars.get(index).getCarID());
            cars.remove(index);
        }
    }

    public boolean isIndexInRange(int index) {
        return index < cars.getIndex();
    }

    public Car getCarByID(int ID) {
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getCarID() == ID) {
                return cars.get(i);
            }
        }
        return null;
    }

    public String showCarsbyOwner(String owner) {
        if (cars.getIndex() == 0) {
            return "No cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder("Your cars: " + System.lineSeparator());
        boolean hasCars = false;
        for (int i = 0; i < cars.getIndex(); i++) {
            if (cars.get(i).getOwnerID().equals(owner)) {
                Car operatedValue = cars.get(i);
                returnbuilder.append("Index : ");
                returnbuilder.append(i);
                returnbuilder.append(" Make: ");
                returnbuilder.append(operatedValue.getMake());
                returnbuilder.append(System.lineSeparator());
                returnbuilder.append("Payments remaining: ");
                returnbuilder.append(operatedValue.getNumPaymentsRemaining());
                returnbuilder.append(System.lineSeparator());
                hasCars = true;
            }
        }
        if (hasCars) {
            return returnbuilder.toString();
        } else return "No cars to list";
    }

    public void MakePaymentbyIndex(int index) {
        Car operatedValue = cars.get(index);
        operatedValue.setNumPaymentsRemaining(operatedValue.getNumPaymentsRemaining() -1);
        if (operatedValue.getNumPaymentsRemaining() == 0) {
            System.out.println("Payments complete, enjoy your new car");
            CarDao.getInstance().remove(operatedValue.getCarID());
            cars.remove(index);
            return;
        }
        System.out.println(operatedValue.getNumPaymentsRemaining() + " Payment(s) remaining");
        CarDao.getInstance().update(operatedValue);
    }

    public String showCarswithPayments() {
        if (cars.getIndex() == 0) {
            return "No cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder("Cars With Payments: " + System.lineSeparator());
        boolean match = false;
        for (int i = 0; i < cars.getIndex(); i++) {
            if (!cars.get(i).getOwnerID().equals("__LOT")) {
                Car operatedValue = cars.get(i);
                match = true;
                returnbuilder.append("Index : ");
                returnbuilder.append(i);
                returnbuilder.append(" Make: ");
                returnbuilder.append(operatedValue.getMake());
                returnbuilder.append(" Owner : ");
                returnbuilder.append(operatedValue.getOwnerID());
                returnbuilder.append(" Payments remaining: ");
                returnbuilder.append(operatedValue.getNumPaymentsRemaining());
                returnbuilder.append(" Balance remaining: ");
                returnbuilder.append(CarService.getInstance().getMonthlyPaymentbyIndex(i));
                returnbuilder.append(System.lineSeparator());
            }
        }
        if (match) {
            return returnbuilder.toString();
        }
        return "No cars to display";
    }

    public double getMonthlyPaymentbyIndex(int index) {
        return (cars.get(index).getPrice()/3);
    }
/*
    public int getCarIDbyIndex(int index) {
        return cars.get(index).getCarID();
    }
 */


    @Override
    public String toString() {
        return "CarService{" +
                "cars=" + cars +
                '}';
    }
}

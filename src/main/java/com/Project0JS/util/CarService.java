package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarService {
    private static GenericArrayList<Car> cars = new GenericArrayList<Car>();
    public void addCar(String make, double price) {
        cars.add(new Car(make));
    }
    public String showCarsForSale (int index) {
        if (cars.getIndex() < index) {
            return "No more cars to list";
        }
        StringBuilder returnbuilder = new StringBuilder();
        for (int i = index; i < cars.getIndex(); i++) {
            returnbuilder.append("Index : " + Integer.toString(i) + cars.get(i).getMake());
        }
        return returnbuilder.toString();
    };
    public void makeOffer(int index, float price) {
        if (cars.getIndex() < index) {
            System.out.println("Invalid Car selection");
        } else {
           System.out.println("Not yet implemented");
        }
    }
    public void removeCar(Car c) {
        //TODO: Handle Car Removal Logic
    }
}

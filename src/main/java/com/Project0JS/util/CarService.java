package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarService {
    private static CarLinkedList cars = new CarLinkedList();
    public void addCar(String make, double price) throws Exception {
        cars.add(new Car(make, price));
    }
    public Car[] showCarsForSale () {
        return cars.toArray();
    };
    public void removeCar(Car c) {
        cars.remove(c);
    }
}

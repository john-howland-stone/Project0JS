package com.Project0JS.ui;

import com.Project0JS.model.User;
import com.Project0JS.util.CarService;
import com.Project0JS.util.Driver;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu {

    private User u;

    public EmployeeMenu(User u) {
        this.u = u;
    }

    @Override
    public void showMenu(Scanner scan) {
        String answer;
        do {
            System.out.println("add car,view all cars, view offers, view payments, remove car, or log out?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("add car")) {
                System.out.println("Enter Car make/model/color ex: Blue Subaru Forester");
                CarService.getInstance().addCar(scan.nextLine());
                if (Driver.debug) {
                    System.out.println(CarService.getInstance().toString());
                }
            } else if(answer.equalsIgnoreCase("view all cars")) {
                System.out.println(CarService.getInstance().showAllCars());
            } else if(answer.equalsIgnoreCase("view offers")) {
                OfferMenu om = new OfferMenu();
                om.showMenu(scan);
            } else if(answer.equalsIgnoreCase("view payments")) {
                System.out.println(CarService.getInstance().showCarswithPayments());
            } else if(answer.equalsIgnoreCase("remove car")) {
                System.out.println(CarService.getInstance().showAllCars());
                System.out.println("Enter Car index to be removed");
                int index = UIUtility.enterInteger(scan);
                if (CarService.getInstance().doesCarExistAtIndex(index)) {
                    CarService.getInstance().removeCar(index);
                } else {
                    System.out.println("Invalid Car Index");
                }
                scan.nextLine();
            }
        } while(!answer.equalsIgnoreCase("log out"));
    }
}

package com.Project0JS.ui;

import com.Project0JS.model.User;
import com.Project0JS.util.CarService;
import com.Project0JS.util.OfferService;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu {

    private User u;

    public EmployeeMenu(User u) {
        this.u = u;
    }

    @Override
    public void showMenu(Scanner scan) {
        String answer = "";
        do {
            System.out.println("add car,view all cars, view offers, view payments, remove car, or log out?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("add car")) {
                System.out.println("Enter Car make/model/color ex: Blue Subaru Forester");
                CarService.addCar(scan.nextLine());
            } else if(answer.equalsIgnoreCase("view all cars")) {
                System.out.println(CarService.showAllCars());
            } else if(answer.equalsIgnoreCase("view offers")) {
                OfferMenu om = new OfferMenu();
                om.showMenu(scan);
            } else if(answer.equalsIgnoreCase("view payments")) {
                System.out.println(CarService.showCarswithPayments());
            } else if(answer.equalsIgnoreCase("remove car")) {
                System.out.println("Enter Car ID to be removed");
                CarService.removeCar(scan.nextInt());
                scan.nextLine();
            }
        } while(!answer.equalsIgnoreCase("log out"));
    }
}

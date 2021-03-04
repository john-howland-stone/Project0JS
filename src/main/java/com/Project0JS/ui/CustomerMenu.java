package com.Project0JS.ui;

import com.Project0JS.model.User;
import com.Project0JS.util.CarService;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu {

    private User u;

    public CustomerMenu(User u) {
        this.u = u;
    }

    @Override
    public void showMenu(Scanner scan) {
        String answer = "";
        do {
            System.out.println("view cars for sale, view my cars, or log out?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("view cars for sale")) {
                SaleMenu sm = new SaleMenu(u);
                sm.showMenu(scan);
            } else if(answer.equalsIgnoreCase("view my cars")) {
                System.out.println(CarService.showCarsbyOwner(u.getUserID()));
                if (!CarService.showCarsbyOwner(u.getUserID()).equalsIgnoreCase("No cars to list")) {
                    if (UIUtility.yOrN(scan,"Do you wish to make a payment?")) {
                        System.out.println("Enter the index of the car you wish to make a payment for");
                        int index = scan.nextInt();
                        if (CarService.isIndexInRange(index)) {
                            scan.nextLine();
                            System.out.println("Amount due is:" + CarService.getMonthlyPaymentbyIndex(index));
                            if (UIUtility.yOrN(scan,"Do you still wish to make a payment?")) {
                                CarService.MakePaymentbyID(index,u.getUserID());
                            } else {
                                System.out.println("Transaction Aborted");
                            }
                        } else {
                            System.out.println("Invalid Car Index");
                            scan.nextLine();
                        }
                    }
                }
            }
        } while(!answer.equalsIgnoreCase("log out"));
    }
}

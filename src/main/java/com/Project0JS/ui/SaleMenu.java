package com.Project0JS.ui;

import com.Project0JS.model.Car;
import com.Project0JS.model.User;
import com.Project0JS.util.CarService;

import java.util.Scanner;

public class SaleMenu extends AbstractMenu {

        private User u;

        public SaleMenu(User u) {
            this.u = u;
        }

        @Override
        public void showMenu(Scanner scan) {
            String answer = "";
            System.out.println(CarService.showCarsForSale());
            if (CarService.showCarsForSale().equalsIgnoreCase("No cars for sale")) {
                System.out.println("returning to previous menu");
            } else {
                do {
                    System.out.println("make an offer or previous menu");
                    answer = scan.nextLine();
                    if(answer.equalsIgnoreCase("make an offer")) {
                        System.out.println("Enter a car index");
                        int index = scan.nextInt();
                        if (CarService.isIndexInRange(index)) {
                            scan.nextLine();
                            System.out.println("Enter a dollar amount without special symbols or commas");
                            float amount = scan.nextFloat();
                            scan.nextLine();
                            CarService.makeOffer(index,amount, u.getUserID());
                        } else {
                            System.out.println("Invalid Car Index");
                            scan.nextLine();
                        }
                    }
                } while(!answer.equalsIgnoreCase("previous menu"));
            }

        }
}

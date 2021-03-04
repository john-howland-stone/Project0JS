package com.Project0JS.ui;

import com.Project0JS.model.User;
import com.Project0JS.util.CarService;
import com.Project0JS.util.Driver;
import com.Project0JS.util.OfferService;

import java.util.Scanner;

public class SaleMenu extends AbstractMenu {

        private User u;

        public SaleMenu(User u) {
            this.u = u;
        }

        @Override
        public void showMenu(Scanner scan) {
            String answer;
            System.out.println(CarService.getInstance().showCarsForSale());
            if (CarService.getInstance().showCarsForSale().equalsIgnoreCase("No cars for sale")) {
                System.out.println("returning to previous menu");
            } else {
                do {
                    System.out.println("make an offer or previous menu");
                    answer = scan.nextLine();
                    if(answer.equalsIgnoreCase("make an offer")) {
                        System.out.println("Enter a car index");
                        int index = UIUtility.enterInteger(scan);
                        if (CarService.getInstance().isIndexInRange(index)) {
                            scan.nextLine();
                            System.out.println("Enter a dollar amount without special symbols or commas");
                            float amount = UIUtility.enterFloat(scan);
                            scan.nextLine();
                            CarService.getInstance().makeOffer(index,amount, u.getUserName());
                        } else {
                            System.out.println("Invalid Car Index");
                            scan.nextLine();
                        }
                    }
                    if (Driver.debug) {
                        System.out.println(OfferService.getInstance().toString());
                    }
                } while(!answer.equalsIgnoreCase("previous menu"));
            }

        }
}

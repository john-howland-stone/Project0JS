package com.Project0JS.ui;

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
            int index = 0;
            CarService cs = new CarService();
            String answer = "";
            do {
                cs.showCarsForSale(index);
                System.out.println("next page, make offer or previous menu");
                answer = scan.nextLine();
                if(answer.equalsIgnoreCase("next page")) {
                    index +=4;
                    if (cs.showCarsForSale(index).equals("No more cars to list")) {
                        index = 0;
                    }
                } else if(answer.equalsIgnoreCase("make an offer")) {
                    System.out.println("Enter a car index");
                    int offerindex = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter a dollar amount without special symbols or commas");
                    float amount = scan.nextFloat();
                    scan.nextLine();
                    cs.makeOffer(index,amount);
                    System.out.println( offerindex + amount + "Not Yet Implemented");
                }
            } while(!answer.equalsIgnoreCase("previous menu"));
        }
}

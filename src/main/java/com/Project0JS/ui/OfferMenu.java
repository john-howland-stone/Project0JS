package com.Project0JS.ui;

import com.Project0JS.util.CarService;
import com.Project0JS.util.OfferService;

import java.util.Scanner;

public class OfferMenu extends AbstractMenu {
    @Override
    public void showMenu(Scanner scan) {
        String answer = "";
        System.out.println(OfferService.showAllOffers());
        if (OfferService.showAllOffers().equalsIgnoreCase("No Offers to list")) {
            System.out.println("returning to previous menu");
        } else {
            do {
                System.out.println("accept offer, reject offer, or previous menu");
                answer = scan.nextLine();
                if(answer.equalsIgnoreCase("accept offer")) {
                    System.out.println("Enter an offer index");
                    int index = scan.nextInt();
                    if (OfferService.isIndexInRange(index)) {
                        scan.nextLine();
                        OfferService.acceptOffer(index);
                    } else {
                        System.out.println("Invalid Offer Index");
                        scan.nextLine();
                    }
                }
                else if(answer.equalsIgnoreCase("reject offer")) {
                    System.out.println("Enter an offer index");
                    int index = scan.nextInt();
                    if (OfferService.isIndexInRange(index)) {
                        scan.nextLine();
                        OfferService.rejectOffer(index);
                    } else {
                        System.out.println("Invalid Offer Index");
                        scan.nextLine();
                    }
                }
            } while(!answer.equalsIgnoreCase("previous menu"));
        }
    }
}

package com.Project0JS.ui;

import com.Project0JS.util.Driver;
import com.Project0JS.util.OfferService;

import java.util.Scanner;

public class OfferMenu extends AbstractMenu {
    @Override
    public void showMenu(Scanner scan) {
        String answer;
        System.out.println(OfferService.getInstance().showAllOffers());
        if (OfferService.getInstance().showAllOffers().equalsIgnoreCase("No Offers to list")) {
            System.out.println("returning to previous menu");
        } else {
            do {
                System.out.println("accept offer, reject offer, or previous menu");
                answer = scan.nextLine();
                if(answer.equalsIgnoreCase("accept offer")) {
                    System.out.println("Enter an offer index");
                    int index = UIUtility.enterInteger(scan);
                    if (OfferService.getInstance().doesOfferExistAtIndex(index)) {
                        scan.nextLine();
                        OfferService.getInstance().acceptOffer(index);
                    } else {
                        System.out.println("Invalid Offer Index");
                        scan.nextLine();
                    }
                    System.out.println(OfferService.getInstance().showAllOffers());
                }
                else if(answer.equalsIgnoreCase("reject offer")) {
                    System.out.println("Enter an offer index");
                    int index = UIUtility.enterInteger(scan);
                    if (OfferService.getInstance().doesOfferExistAtIndex(index)) {
                        scan.nextLine();
                        OfferService.getInstance().rejectOffer(index);
                    } else {
                        System.out.println("Invalid Offer Index");
                        scan.nextLine();
                    }
                    System.out.println(OfferService.getInstance().showAllOffers());
                }
                if (Driver.debug) {
                    System.out.println(OfferService.getInstance().toString());
                }
            } while(!answer.equalsIgnoreCase("previous menu"));
        }
    }
}

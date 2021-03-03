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
        CarService cs = new CarService();
        String answer = "";
        do {
            System.out.println("view cars for sale, see my cars, or log out?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("view cars for sale")) {
                SaleMenu sm = new SaleMenu(u);
                sm.showMenu(scan);
            } else if(answer.equalsIgnoreCase("view my cars")) {
                System.out.println("Not yet implemented");
            }
        } while(!answer.equalsIgnoreCase("log out"));
    }
}

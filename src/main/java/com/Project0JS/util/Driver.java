package com.Project0JS.util;

import com.Project0JS.ui.LoginMenu;
import com.Project0JS.ui.SignUpMenu;

import java.util.Scanner;

public class Driver {

    public static final boolean debug = true;

    public static void main(String [] args) {

        UserService.getInstance().setUsers(UserDao.getInstance().getAll());
        CarService.getInstance().setCars(CarDao.getInstance().getAll());
        OfferService.getInstance().setOffers(OfferDao.getInstance().getAll());
        if (Driver.debug) {
            System.out.println(UserService.getInstance());
            System.out.println(CarService.getInstance());
            System.out.println(OfferService.getInstance());
        }
        Scanner scan = new Scanner(System.in);
        SignUpMenu sm = new SignUpMenu();
        LoginMenu lm = new LoginMenu();
        String answer;
        System.out.println("====Welcome to JS's Cars====");
        do {
            System.out.println("sign up, login or exit?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("sign up")) {
                sm.showMenu(scan);
            } else if(answer.equalsIgnoreCase("login")) {
                lm.showMenu(scan);
            }
        } while(!answer.equalsIgnoreCase("exit"));

    }

}

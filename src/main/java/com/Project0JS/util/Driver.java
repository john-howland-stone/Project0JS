package com.Project0JS.util;

import com.Project0JS.ui.LoginMenu;
import com.Project0JS.ui.SignUpMenu;
import com.enterprise.model.MetaTestData;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Driver {

    public static final boolean debug = false;

    public static void main(String [] args) {

        UserService.getInstance().setUsers(UserDao.getInstance().getAll());
        CarService.getInstance().setCars(CarDao.getInstance().getAll());
        OfferService.getInstance().setOffers(OfferDao.getInstance().getAll());
        if (Driver.debug) {
            System.out.println(UserService.getInstance());
            System.out.println(CarService.getInstance());
            System.out.println(OfferService.getInstance());
            HashMap<Method, MetaTestData> resultmap = null;
            try {
                resultmap = new TestDiscovery().runAndStoreTestInformation();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(resultmap);
            }
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

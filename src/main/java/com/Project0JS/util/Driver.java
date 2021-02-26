package com.Project0JS.util;

//import com.Project0JS.ui.LoginMenu;
import com.Project0JS.ui.SignUpMenu;

import java.util.Scanner;

public class Driver {
    //private final boolean debug = false;
    public static void main(String [] args) {

        Scanner scan = new Scanner(System.in);
        SignUpMenu sm = new SignUpMenu();
        //LoginMenu lm = new LoginMenu();
        String answer;
        do {
            System.out.println("sign up, login or exit?");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("sign up")) {
                sm.showMenu(scan);
            }
                //TODO implement login menu
            //} else if(answer.equalsIgnoreCase("login")) {
            //    lm.showMenu(scan);
            //}
        } while(!answer.equalsIgnoreCase("exit"));

    }

}

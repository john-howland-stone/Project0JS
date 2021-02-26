package com.Project0JS.ui;

import com.Project0JS.util.UserService;

import java.util.Scanner;

public class SignUpMenu extends AbstractMenu {

    @Override
    public void showMenu(Scanner scan) {
        UserService us = new UserService();
        System.out.println("====Welcome to JS's Cars====");
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
        } while(us.doesUsernameExist(username));
        System.out.println("provide password");
        String password = scan.nextLine();
        try {
            us.makeUser(username, password);
        } catch (Exception e) {
            System.out.println("User Already Exists");
        }
        System.out.println("successfully made " + username);
    }
}

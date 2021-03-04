package com.Project0JS.ui;

import com.Project0JS.util.UserService;

import java.util.Scanner;

public class SignUpMenu extends AbstractMenu {

    @Override
    public void showMenu(Scanner scan) {
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            if (!UserService.doesUsernameExist(username)) {
                break;
            } else {
                System.out.println("User Already Exists");
            }
        } while(true);
        System.out.println("provide password");
        String password = scan.nextLine();
        UserService.makeUser(username, password);
        System.out.println("successfully made " + username);
    }
}

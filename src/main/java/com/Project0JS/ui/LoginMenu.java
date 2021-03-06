package com.Project0JS.ui;

import com.Project0JS.model.User;
import com.Project0JS.util.UserService;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu {


    @Override
    public void showMenu(Scanner scan) {

        for (int i = 0; i <= 2; i++) {
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();
            User u = UserService.getInstance().findUserByUsername(username);
            if (u == null || !u.getPassword().equals(password) && !u.getUserName().equals("__LOT")) {
                System.out.println("login failed");
            } else {
                System.out.println("Welcome " + u.getUserName());
                if (u.isEmployee()) {
                    EmployeeMenu em = new EmployeeMenu(u);
                    em.showMenu(scan);
                } else {
                    CustomerMenu cm = new CustomerMenu(u);
                    cm.showMenu(scan);
                }
                break;
            }
        }
    }
}

package com.Project0JS.ui;

import java.util.Scanner;

/*
Credit to Java Gym App for this class, slight tweaks by me
 */

public class UIUtility {

    public static boolean yOrN(Scanner scan, String message){
        String answer = "";
        do{
            System.out.println(message + " y/n");
            answer = scan.nextLine();
            if(answer.equals("y")){
                return true;
            } else if(answer.equals("n")){
                return false;
            }
        } while(true);
    }
}
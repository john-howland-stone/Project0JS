package com.Project0JS.model;

import java.util.Objects;

public class User {
    private int userID;
    private String userName;
    private String password;

    private boolean isEmployee = false;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.userID = 1; //TODO make this work with SQL
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

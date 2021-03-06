package com.Project0JS.model;

import java.util.Objects;

public class User {
    private String userName;
    private String password;

    private boolean isEmployee = false;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, boolean isEmployee) {
        this.userName = userName;
        this.password = password;
        this.isEmployee = isEmployee;
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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isEmployee=" + isEmployee +
                '}';
    }
}

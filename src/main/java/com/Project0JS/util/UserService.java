package com.Project0JS.util;

import com.Project0JS.model.User;

public class UserService {
    private GenericArrayList<User> users = new GenericArrayList<>();

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {

    }

    public void makeUser(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean doesUsernameExist(String username) {
        if (users.getIndex() < 1) {
            return false;
        }
        for (int i = 0; i < users.getIndex(); i++) {
            if (users.get(i).getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User findUserByUsername(String username) {
        if (users.getIndex() < 1) {
            return null;
        }
        for (int i = 0; i < users.getIndex(); i++) {
            if (users.get(i).getUserName().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "users=" + users +
                '}';
    }
}
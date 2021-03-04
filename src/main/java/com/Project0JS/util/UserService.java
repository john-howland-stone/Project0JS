package com.Project0JS.util;

import com.Project0JS.model.User;

public class UserService {
    private static GenericArrayList<User> users = new GenericArrayList<User>();
    public static void makeUser(String username, String password) {
        int open_key = 1;
        for (int i = 0; i < users.getIndex(); i++) {
            if (users.get(i).getUserID() == open_key) {
                open_key++;
            }
        }
        users.add(new User(username,password,open_key));
    }
    public static boolean doesUsernameExist(String username) {
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

    public static User findUserByUsername(String username) {
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
}
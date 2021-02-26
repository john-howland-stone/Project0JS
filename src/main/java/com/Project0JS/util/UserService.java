package com.Project0JS.util;

import com.Project0JS.model.User;

public class UserService {
    private static UserLinkedList users = new UserLinkedList();
    public void makeUser(String username, String password) throws Exception {
        users.add(new User(username,password));
    }
    public boolean doesUsernameExist(String username) {
        return users.get(username) !=null;
    }

    public User findUserByUsername(String username) {
        return users.get(username);
    }
}

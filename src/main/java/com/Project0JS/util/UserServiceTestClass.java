package com.Project0JS.util;

import com.enterprise.annotations.TestMethod;
import com.enterprise.annotations.TestClass;

@com.enterprise.annotations.TestClass
public class UserServiceTestClass {
    @TestMethod(name = "Find User by Username test",expected = "User{userName='__LOT', password='__ROOT', isEmployee=true}")
    public String testMethod1 () {
        return UserService.getInstance().findUserByUsername("__LOT").toString();
    }
}

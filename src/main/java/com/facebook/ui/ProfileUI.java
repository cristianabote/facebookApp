package com.facebook.ui;

import com.facebook.service.UserService;

public class ProfileUI {

    private UserService userService = new UserService();

    public void displayUserLoggedIn(){
        System.out.println("This is my profile");

    }

}

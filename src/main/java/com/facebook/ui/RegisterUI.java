package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.service.UserService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class RegisterUI {

    private UserService userService = new UserService();

    public void displayRegister(){

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter Email Address: ");
        String email = input.nextLine();
        System.out.printf("Enter Your Password: ");
        String password = input.nextLine();
        System.out.printf("Enter Name:");
        String name = input.nextLine();
        try {
            userService.register(email, password, name);
            System.out.println("User successfully registered");
            MainUI mainUI = new MainUI();
            mainUI.start();
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
            MainUI mainUI = new MainUI();
            mainUI.start();
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }
}

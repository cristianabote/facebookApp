package com.facebook.ui;

import sun.rmi.runtime.Log;

import java.util.Scanner;

public class MainUI {

//    private LoginUI loginUI = new LoginUI();
//    private RegisterUI registerUI = new RegisterUI();

    public void start() {

        Scanner loginScanner = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("Enter your option: ");

        int option = Integer.parseInt(loginScanner.next());


        if (option == 1) {
            System.out.println("Please Login ");
            LoginUI loginUI = new LoginUI();
            loginUI.displayLogin();
        }
        if (option == 2) {
            {
                System.out.println("Please Register ");
                RegisterUI registerUI = new RegisterUI();
                registerUI.displayRegister();
            }



        }

    }
}

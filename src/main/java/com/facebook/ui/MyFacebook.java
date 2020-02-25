package com.facebook.ui;

import com.facebook.exception.FbTechnicalException;

import java.io.IOException;
import java.util.Scanner;

public class MyFacebook {

    public static void showOption() throws IOException, FbTechnicalException {
        Scanner firstScreenAfterLoginScanner = new Scanner(System.in);
        System.out.println("1. See Profile");
        System.out.println("2. Add Friend");
        System.out.println("3. Feed");
        System.out.println("4. Logout");
        System.out.println("Enter your option: ");

        int option = Integer.parseInt(firstScreenAfterLoginScanner.next());


        if (option == 1) {
            ProfileUI profileUI = new ProfileUI();
            profileUI.displayUserLoggedIn();
        }
        if (option == 2) {
            {
                System.out.println("Please Sign Up ");
                SignUpUI signUpUI = new SignUpUI();
                signUpUI.displaySignUp();
            }
            if (option == 3){
                System.out.println("Please Sign Up ");
            }

        }
        if (option == 4) {
            {
                MainUI mainUI = new MainUI();
                mainUI.start();
            }

        }

    }
}

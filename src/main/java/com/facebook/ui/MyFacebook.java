package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;

import java.io.IOException;
import java.util.Scanner;

public class MyFacebook {

    public static void showOption() throws IOException, FacebookException {
        Scanner firstScreenAfterLoginScanner = new Scanner(System.in);
        System.out.println("1. View NewsFeed");
        System.out.println("2. View Friends");
        System.out.println("3. Logout");
        System.out.println("Enter your option: ");

        int option = Integer.parseInt(firstScreenAfterLoginScanner.next());


        if (option == 1) {
            NewsFeedUi newsFeedUi = new NewsFeedUi();
            newsFeedUi.displayNewsFeed();
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

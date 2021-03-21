package com.facebook.ui;

import com.facebook.exception.FacebookException;
import java.io.IOException;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MyFacebook {

    public static void showOption(String userName) throws IOException, FacebookException {
        Scanner firstScreenAfterLoginScanner = new Scanner(System.in);
        System.out.println("1. View NewsFeed");
        System.out.println("2. View Friends");
        System.out.println("3. Logout");
        System.out.println("Enter your option: ");

        int option = Integer.parseInt(firstScreenAfterLoginScanner.next());


        if (option == 1) {
            NewsFeedUi newsFeedUi = new NewsFeedUi();
            newsFeedUi.displayNewsFeed(userName);
        }
        if (option == 2) {
                System.out.println("No Friends");
            }
            if (option == 3){
                MainUI mainUI = new MainUI();
                mainUI.start();
        }

    }
}

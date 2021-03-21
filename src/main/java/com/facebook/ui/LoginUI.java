package com.facebook.ui;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.service.UserService;

import java.io.IOException;
import java.util.Scanner;

import static com.facebook.ui.MyFacebook.showOption;

public class LoginUI {

    private UserService userService = new UserService();

    public void displayLogin() throws IOException, FbTechnicalException {
        Scanner loginScanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email = loginScanner.next();
        System.out.println("Password: ");
        String password = loginScanner.next();
        try {
            userService.login(email, password);
            System.out.println("Welcome "+ email);
            showOption(email);

        } catch (FbWrongCredentialsException e) {
            System.out.println("Wrong Credentials");
            MainUI mainUI = new MainUI();
            mainUI.start();
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (FacebookException e) {
            e.printStackTrace();

        }



    }
}

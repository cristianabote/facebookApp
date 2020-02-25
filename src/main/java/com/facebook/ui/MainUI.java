package com.facebook.ui;

import com.facebook.exception.FbTechnicalException;

import java.io.IOException;
import java.util.Scanner;

public class MainUI {

    private LoginUI loginUI = new LoginUI();
    private SignUpUI signUpUI=new SignUpUI();
    private EditSettingsUI editSettingsUI = new EditSettingsUI();
//    private SignUpUI signUpUI

    public void start() throws IOException, FbTechnicalException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login:");
        System.out.println("2. Signup:");
        System.out.println("3. Edit settings: ");
        System.out.println("Enter your option");
        String opt = scanner.nextLine();
        switch (opt) {
            case "1":
                loginUI.displayLogin();break;
            case "2":
                signUpUI.displaySignUp();break;
            case "3":
                editSettingsUI.displayEditSettings();break;
            default:
                System.out.println("Invalid option");
        }
    }

}

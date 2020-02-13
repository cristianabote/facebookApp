package com.facebook.ui;

import java.io.IOException;
import java.util.Scanner;

public class MainUI {

    private LoginUI loginUI = new LoginUI();
    private SignUpUI signUpUI=new SignUpUI();
    private EditSettingsUI editSettingsUI = new EditSettingsUI();
//    private SignUpUI signUpUI

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option (1 - login, 2 - signup, 3 - edit settings: ");
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

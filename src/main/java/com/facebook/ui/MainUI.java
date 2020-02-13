package com.facebook.ui;

import java.io.IOException;

public class MainUI {

    private LoginUI loginUI = new LoginUI();
    private SignUpUI signUpUI=new SignUpUI();
    private EditSettingsUI editSettingsUI = new EditSettingsUI();
//    private SignUpUI signUpUI

    public void start() throws IOException {
       // loginUI.displayLogin();
        // signUpUI.displaySignUp();
        editSettingsUI.displayEditSettings();
    }

}

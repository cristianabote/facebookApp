package com.facebook;

import com.facebook.exception.FbTechnicalException;
import com.facebook.ui.MainUI;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, FbTechnicalException {
        new MainUI().start();
    }
}
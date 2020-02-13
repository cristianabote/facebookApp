package com.facebook.service;

import com.facebook.dao.UserDAO;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class UserService {

    private static final String USERS_FILE = "C:/Users/Soundrob/IdeaProjects/FacebookApp/facebookApp/src/main/java/users.txt";

    private UserDAO userDAO = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws FacebookException {
        for (User user : userDAO.readAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }


        throw new FbWrongCredentialsException();
    }

    public void register(String name, String email, String password) throws FacebookException {
        File f=new File(USERS_FILE);
        PrintWriter pw= null;
        try {
            pw = new PrintWriter(new FileOutputStream(f,true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.append("\n"+name+";"+email+";"+password);
        pw.close();
    }
}

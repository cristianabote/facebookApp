package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String USERS_FILE = "C:/Users/Soundrob/IdeaProjects/FacebookApp/facebookApp/src/main/java/users.txt";

    public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            String[] userValues = userLine.split(";");

            userList.add(new User(userValues[0], userValues[1], userValues[2]));
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return userList;
    }

}

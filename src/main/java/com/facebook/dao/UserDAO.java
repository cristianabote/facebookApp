package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String USERS_FILE = "/Users/andrei/IdeaProjects/exception-handling/src/main/resources/users.txt";

    public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            String[] userValues = userLine.split(";");

            userList.add(new User(userValues[0], userValues[1]));
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return userList;
    }
}

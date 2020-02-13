package com.facebook.service;

import com.facebook.dao.UserDAO;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.ProfileInfo;
import com.facebook.model.User;

import java.io.IOException;
import java.util.Date;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User login(String email, String password) throws FacebookException {
        for (User user : userDAO.readAllUsers()) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        throw new FbWrongCredentialsException();
    }

    public void signUp(String email, String password, String name) throws FacebookException, IOException {
        User user = new User(email, password, name);
        userDAO.writeUser(user);
    }

    public void editSettings(String password, String name) throws FacebookException, IOException {
        //User user = new User(password, name);
        //userDAO.editUserSettings(user);
    }
    public void editProfile(String phoneNumber, Date dateOfBirth, String maritalStatus, String gender, String city, String job) throws FacebookException, IOException {
        ProfileInfo profileInfoUser = new ProfileInfo(phoneNumber, dateOfBirth, maritalStatus, gender, city, job);
        userDAO.editUserProfile(profileInfoUser);
    }
}

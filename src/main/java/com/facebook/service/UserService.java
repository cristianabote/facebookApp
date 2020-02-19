package com.facebook.service;

import com.facebook.dao.UserDao;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.model.ProfileInfo;
import com.facebook.model.User;

import java.io.IOException;
import java.util.Date;

public class UserService {

    private UserDao userDAO = new UserDao();

    public User login(String email, String password) throws FacebookException {
        for (User user : userDAO.readAllUsers()) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        throw new FbWrongCredentialsException();
    }

    public void signUp(String email, String name,String password, String role, String phoneNumber, String dateOfBirth, String maritalStatus, String gender, String city, String job) throws FacebookException, IOException {
        ProfileInfo newUserProfile = new ProfileInfo(email, name, phoneNumber, dateOfBirth, maritalStatus, gender, city, job);
        User newUser = new User(email, password, role);
        userDAO.writeUser(newUserProfile, newUser);
    }

    public void editSettings(String password, String name) throws FacebookException, IOException {
        //User user = new User(password, name);
        //userDAO.editUserSettings(user);
    }
    public void editProfile(String email, String password, String name, String phoneNumber, String dateOfBirth, String maritalStatus, String gender, String city, String job) throws FacebookException, IOException {
        ProfileInfo profileInfoUser = new ProfileInfo(email, name, phoneNumber, dateOfBirth, maritalStatus, gender, city, job);
        userDAO.editUserProfile(profileInfoUser);
    }
}

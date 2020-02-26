package com.facebook.dao;

import com.facebook.exception.FacebookException;
import com.facebook.exception.FbFileException;
import com.facebook.exception.FbInexistentEmail;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.ProfileInfo;
import com.facebook.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String USERS_FILE = "./src/main/java/com/facebook/users.txt";
    private static final String USER_INFO = "./src/main/java/com/facebook/usersOutputProfile.txt";


    public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        try (
            BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))){
            while ((userReader.readLine()) != null) {
                String userLine = userReader.readLine();
                String[] userValues = userLine.split(";");

                userList.add(new User(userValues[0], userValues[1], userValues[2]));
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return userList;
    }
    public void writeUser(ProfileInfo newUserProfile,  User newUser ) throws FbTechnicalException, IOException {
        System.out.println("New user:" + newUser.getEmail() + ";" + newUser.getPassword());
        Writer outputStream;
        outputStream = new BufferedWriter(new FileWriter(USERS_FILE, true));
        outputStream.write(newUser.getEmail() + ";" + newUser.getPassword());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

        Writer outputStream2;
        outputStream2 = new BufferedWriter(new FileWriter(USER_INFO,true));
        outputStream2.write(newUserProfile.getEmail()  + ";" + newUserProfile.getName() + ";" + newUserProfile.getPhoneNumber()+ ";" + newUserProfile.getDateOfBirth()+ ";" + newUserProfile.getGender()
                + ";" + newUserProfile.getCity()+ ";" + newUserProfile.getMaritalStatus()+ ";" + newUserProfile.getJob());
        ((BufferedWriter) outputStream2).newLine();
        outputStream2.close();

    }

    public void editUserSettings(User newUser) throws FbTechnicalException, IOException {
        System.out.println("Update user Settings:" + newUser.getEmail() + ";" + newUser.getPassword());
        Writer outputStream;

        outputStream = new BufferedWriter(new FileWriter(USERS_FILE, true));
        outputStream.write(newUser.getEmail() + ";" + newUser.getPassword());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }

    public void editUserProfile(ProfileInfo newUser) throws FbTechnicalException, IOException {
        System.out.println("Update user profile :" + newUser.getPhoneNumber() + ";" + newUser.getDateOfBirth() + ";" + newUser.getMaritalStatus() + ";" + newUser.getGender() + ";" + newUser.getCity() + ";" + newUser.getJob());
        Writer outputStream;

        outputStream = new BufferedWriter(new FileWriter(USERS_FILE, true));
        outputStream.write(newUser.getPhoneNumber() + ";" + newUser.getDateOfBirth() + ";" + newUser.getMaritalStatus() + ";" + newUser.getGender() + ";" + newUser.getCity() + ";" + newUser.getJob());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }

    public void checkEmail(String email) throws FbInexistentEmail, FbTechnicalException {

        List<User> userList;
        userList = readAllUsers();
        boolean emailFound = false;
        for (User user : userList)
            if (user.getEmail().equals(email))
                emailFound = true;
        if (!emailFound)
            throw new FbInexistentEmail();

    }

    public void editSettings(String email, String password) throws FbTechnicalException, IOException {
        List<User> userList;
        userList = readAllUsers();
        for (User user : userList)
            if (user.getEmail().equals(email)) {
                if (password.length() > 0) //then modify password
                    user.setPassword(password);
//                if (name.length() > 0)  //then modify name
//                    user.setName(name);
            }
        Writer outputStream = new BufferedWriter(new FileWriter(USERS_FILE));
        for (User user : userList)
        //System.out.println(user.getEmail()+" "+user.getPassword()+" "+user.getName());  // test modify user

        {

            outputStream.write(user.getEmail() + ";" + user.getPassword());
            ((BufferedWriter) outputStream).newLine();
        }
        outputStream.close();
    }

}

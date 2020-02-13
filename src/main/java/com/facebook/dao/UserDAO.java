package com.facebook.dao;

import com.facebook.exception.FbFileException;
import com.facebook.exception.FbTechnicalException;
import com.facebook.model.ProfileInfo;
import com.facebook.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    private static final String USERS_FILE = "c:\\JAVA\\proiecte\\facebookApp\\src\\main\\java\\com\\facebook\\users.txt";

            public List<User> readAllUsers() throws FbTechnicalException {
        List<User> userList = new ArrayList<>();
        Scanner scannerText=null;
        try {
            scannerText=new Scanner(new BufferedReader(new FileReader(USERS_FILE)));
            String userLine="";
            while(scannerText.hasNextLine()){
                    userLine = scannerText.nextLine();
            String[] userValues = userLine.split(";");

            userList.add(new User(userValues[0], userValues[1], userValues[2]));
            }
        } catch (IOException e) {
            throw new FbFileException("Error reading users", e);
        }

        return userList;
    }
    public void writeUser(User newUser) throws FbTechnicalException, IOException {
        System.out.println("New user:" + newUser.getEmail() + ";" + newUser.getPassword()+";"+ newUser.getName());
        Writer outputStream = null;

            outputStream = new BufferedWriter(new FileWriter("c:\\JAVA\\proiecte\\facebookApp\\src\\main\\java\\com\\facebook\\users.txt",true));
            outputStream.write(newUser.getEmail() + ";" + newUser.getPassword()+";"+ newUser.getName());
            ((BufferedWriter) outputStream).newLine();
            outputStream.close();

    }
    public void editUserSettings(User newUser) throws FbTechnicalException, IOException {
        System.out.println("Update user Settings:" + newUser.getEmail() + ";" + newUser.getPassword() + ";"+ newUser.getName());
        Writer outputStream = null;

        outputStream = new BufferedWriter(new FileWriter("c:\\JAVA\\FacebookAppProject\\src\\main\\java\\ro\\facebook\\users.txt",true));
        outputStream.write(newUser.getEmail() + ";" + newUser.getPassword()+";"+newUser.getName());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }
    public void editUserProfile(ProfileInfo newUser) throws FbTechnicalException, IOException {
        System.out.println("Update user profile :" + newUser.getPhoneNumber() + ";" + newUser.getDateOfBirth() + ";"+ newUser.getMaritalStatus()+";"+ newUser.getGender()+";"+newUser.getCity()+";"+ newUser.getJob());
        Writer outputStream = null;

        outputStream = new BufferedWriter(new FileWriter("c:\\JAVA\\proiecte\\facebookApp\\src\\main\\java\\com\\facebook\\usersOutputProfile.txt",true));
        outputStream.write(newUser.getPhoneNumber() + ";" + newUser.getDateOfBirth() + ";"+ newUser.getMaritalStatus()+";"+ newUser.getGender()+";"+newUser.getCity()+";"+ newUser.getJob());
        ((BufferedWriter) outputStream).newLine();
        outputStream.close();

    }
}

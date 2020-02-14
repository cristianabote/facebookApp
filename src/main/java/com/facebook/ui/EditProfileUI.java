package com.facebook.ui;
import com.facebook.exception.FacebookException;
import com.facebook.exception.FbInvalidNumber;
import com.facebook.exception.FbTechnicalException;
import com.facebook.exception.FbWrongCredentialsException;
import com.facebook.service.UserService;
import com.facebook.ui.validator.UserValidator;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EditProfileUI {

    private UserService userService = new UserService();
    private UserValidator userValidator = new UserValidator();

    public void displayEditProfile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Date Of Birth: ");
        String dateOfBirthString = scanner.nextLine();
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthString);
        } catch(Exception e) {
            System.out.println("Invalid date format.");
        }
        System.out.println("Marital Status: ");
        String maritalStatus = scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Job: ");
        String job = scanner.nextLine();
        try {
            //userValidator.validateUserCredentials(phoneNumber,dateOfBirth,maritalStatus,gender,city,job);
            userService.editProfile(phoneNumber,dateOfBirth,maritalStatus,gender,city,job);
            System.out.println("User's profile successfully modified");
        } catch (FbWrongCredentialsException e) {
            System.out.println("Wrong Credentials");
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (FbInvalidNumber e) {
            System.out.println("Wrong Phone Number");
        } catch (FacebookException e) {
            e.printStackTrace();

        }
    }
}



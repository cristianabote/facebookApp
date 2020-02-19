package com.facebook.ui;

import com.facebook.exception.*;
import com.facebook.service.UserService;
import com.facebook.ui.validator.UserValidator;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class SignUpUI {

    private UserService userService = new UserService();
    private UserValidator userValidator=new UserValidator();

    public void displaySignUp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Role: ");
        String role = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Date of Birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Marital Status: ");
        String maritalStatus = scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Job: ");
        String job = scanner.nextLine();

            try {
                userValidator.validateUserCredentials(email,password);
                userService.signUp(email, password, role,  name, phoneNumber, dateOfBirth, maritalStatus, gender, city, job);
                System.out.println("User successfully added");
                LoginUI loginUI = new LoginUI();
                loginUI.displayLogin();
            } catch (FbShortPasswordException e) {
                System.out.println("Password is too short");
                SignUpUI signUpUI = new SignUpUI();
                signUpUI.displaySignUp();
            } catch (FbStrongPasswordException e){
                System.out.println("Password is not strong");
                SignUpUI signUpUI = new SignUpUI();
                signUpUI.displaySignUp();
            } catch (FbEmailInvalid e) {
                System.out.println("Email invalid");
                SignUpUI signUpUI = new SignUpUI();
                signUpUI.displaySignUp();
            } catch (FbTechnicalException e) {
                e.printStackTrace();
                System.out.println("A system error appeared. Please contact your administrator");
            } catch (FacebookException e) {
                e.printStackTrace();
            }
    }
}

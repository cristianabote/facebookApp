package com.facebook.ui;
import com.facebook.dao.UserDao;
import com.facebook.exception.*;
import com.facebook.service.UserService;
import com.facebook.ui.validator.UserValidator;
import java.io.IOException;
import java.util.Scanner;

public class EditSettingsUI {

    private UserService userService = new UserService();
    private UserValidator userValidator=new UserValidator();
    private UserDao userDAO=new UserDao();

    public void displayEditSettings() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        try {
            userDAO.checkEmail(email);
            System.out.println("New Password: ");
            String password = scanner.nextLine();
            System.out.println("New name: ");
            String name = scanner.nextLine();
            if(password.length()>0)
                userValidator.validateUserCredentials(email,password);
//            if(name.length()>0)
//                userValidator.validateUserName(name);
//            userDAO.editSettings(email,password,name);
//            System.out.println("User's settings successfully modified");
        } catch (FbInexistentEmail e) {
            System.out.println("Inexistent email");
        } catch (FbShortPasswordException e) {
            System.out.println("Password is too short");            //parola
        } catch (FbStrongPasswordException e){
            System.out.println("Password is not strong");           //parola
        } catch (FbEmailInvalid e) {
            System.out.println("Email invalid");
        } catch (FbNameNullException e) {
            System.out.println("Empty name");                   //nume
        } catch (FbTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }
}



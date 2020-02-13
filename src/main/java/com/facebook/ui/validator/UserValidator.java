package com.facebook.ui.validator;
import com.facebook.exception.*;
import java.util.Date;
import java.util.regex.Pattern;


public class UserValidator {

    public void validateUserCredentials(String email, String password) throws FbShortPasswordException, FbEmailInvalid, FbStrongPasswordException, FbNameNullException {
        int ok1 = 0, ok2 = 0, ok3 = 0,ok4=0;
        if (password.length() < 5)                                  //parola
            throw new FbShortPasswordException();
        else {
            for (int i = 0; i < password.length(); i++)
                if (Character.isUpperCase(password.charAt(i)))
                    ok1++;
            for (int j = 0; j < password.length(); j++)
                if (Character.isLowerCase(password.charAt(j)))
                    ok2++;
            for (int k = 0; k < password.length(); k++)
                if (Character.isDigit(password.charAt(k)))
                    ok3++;
            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            if(!p.matcher(password).matches())
                ok4++;
            if (ok1 < 1 || ok2 < 1 || ok3 < 1 || ok4 < 1)
                throw new FbStrongPasswordException();
        }
        Pattern pattern=Pattern.compile("[a-zA-Z0-9-_$]+@[a-zA-Z0-9-_$]+\\.[a-zA-Z0-9-_$]{2,6}");
        if(!pattern.matcher(email).matches())
            throw new FbEmailInvalid();


    }
    public void validateUserName(String name) throws FbNameNullException
    {
         if (name == null)                                   //nume
            throw new FbNameNullException();
    }
    public void validateUserProfile(String phoneNumber, Date dateOfBirth,String maritalStatus,String gender,String city,String job) throws FbInvalidNumber
    {
      Pattern pattern=Pattern.compile("\\(?07\\d{2}\\)?[\\s-]\\d{3}[\\s-]?\\d{3}");
        if(!pattern.matcher(phoneNumber).matches())
            throw new FbInvalidNumber();
    }
}

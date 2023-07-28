package util;

import exception.EmailExistException;
import exception.EmailPatternException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public boolean EmailPatternValidator(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        return Pattern.compile(regex,Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }



    public boolean passwordValidator(String password) {
        boolean isValid;
        if (password != null) {
            String regex = "^(?=.*[A-Z])(?=.*[\\W])(?=.*[0-9])(?=.*[a-z]).{8,128}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            isValid = matcher.matches();
        } else return false;
        return isValid;
    }
}

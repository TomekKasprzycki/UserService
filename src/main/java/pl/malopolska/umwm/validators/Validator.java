package pl.malopolska.umwm.validators;

import org.springframework.stereotype.Service;
import pl.malopolska.umwm.Dto.UserDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validator {

    public boolean isPasswordValid(UserDto userDto) {

        final Pattern pattern = Pattern.compile("^([!@#$%^&*()a-zA-Z0-9]*\\d*[A-Z]+\\d*[!@#$%^&*()a-zA-Z0-9]*\\d*)+$");
        final String pass1 = userDto.getPassword();
        final String pass2 = userDto.getPassword2();
        final Matcher matcher = pattern.matcher(pass1);
        final boolean condition1 = pass1.equals(pass2);
        final boolean condition2 = matcher.matches();
        final boolean condition3 = pass1.length() > 7 && pass1.length() < 17;

        return condition1 && condition2 && condition3;
    }

    public boolean isEmailValid(String email){

        final Pattern pattern = Pattern.compile("^([a-zA-Z0-9_]+)(\\.[a-zA-Z0-9_]+)*(@)([a-zA-Z0-9]+)(\\-{1}[a-zA-Z0-9])*\\.[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*$");
        final Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


}

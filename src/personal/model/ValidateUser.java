package personal.model;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

import java.util.regex.Pattern;

public class ValidateUser {

    private Pattern patternName = Pattern.compile("^\\S*$");
    private Pattern patternNumber = Pattern.compile("^\\d*$");


    public void check (User user) throws Exception {
        if (!patternName.matcher(user.getFirstName()).find()) {
            throw new Exception("Неверный формат имени ");
        }
        if (!patternName.matcher(user.getLastName()).find()) {
            throw new Exception("Неверный формат фамилии ");
        }
        if (!patternNumber.matcher(user.getPhone()).find()) {
            throw new Exception("Неверный формат телефона ");
        }


    }

}

package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "abcedfgh"; //8자
    }
}

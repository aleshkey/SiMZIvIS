package org.example.util;

public class Checker {

    private final Generator generator = new Generator();
    public long check(String password){
        var startTime = System.currentTimeMillis();
        String attempt = generator.createPassword(password.length());
        while (!attempt.equals(password)){
            attempt = generator.createPassword(password.length());
        }
        return System.currentTimeMillis()-startTime;
    }

}

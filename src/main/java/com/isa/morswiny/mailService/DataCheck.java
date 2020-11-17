package com.isa.morswiny.mailService;

public class DataCheck {

    public static boolean isEmailCorrect(String email){

        if (email == null){
            return false;
        }

        if (!email.contains(".") || !email.contains("@")){
            return false;
        }

        return email.length() >= 5;
    }
}

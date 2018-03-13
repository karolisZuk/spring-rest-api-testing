package com.repository;

import java.math.BigDecimal;

public class UserToken {

    private long result;

    public UserToken(){
        result=1125899906842597L;
    }

    public String generateToken(String name, String password){
        int len=name.length()+password.length();
        String finalString=name+password;

        for(int i=0; i<len; i++){
            result=31*result+finalString.charAt(i);
        }
        return String.valueOf(result);
    }
}

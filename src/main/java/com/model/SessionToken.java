package com.model;

import java.util.Random;

public class SessionToken {

    private long result=21;
    private String sessionId;
    private String name;
    private String password;

    public SessionToken(String name, String password) {
       this.name=name;
       this.password=password;
    }


    public String getSessionToken() {
        int len=this.name.length()+this.password.length();
        Random rand = new Random();
        String finalString=name+password;

        int  n = rand.nextInt(999999) + 1;
        result=31*result+name.hashCode()+password.hashCode()+Integer.toUnsignedLong(n);

        for(int i=0; i<len; i++){
            result=31*result+finalString.charAt(i);
        }

        sessionId=String.valueOf(result+n);
        return sessionId;
    }
}

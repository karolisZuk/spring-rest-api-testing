package com.com.beans.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;

import java.util.HashMap;
import java.util.Map;

public class LoginResponse extends Response {
    private String name;
    private String sessionId;


    public LoginResponse(String sessionId, User user){
        this.sessionId=sessionId;
        this.name=user.getName();
    }

    public LoginResponse(){
        System.out.println("User was not able to login.");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

package com.com.beans.response;

import com.model.User;

public class UserResponse extends Response {
    private String id;
    private String name;
    private String email;
    private String token;
    private String sessionId;

    public UserResponse(){
        System.out.println("User was not able to login.");
    }

    public UserResponse(User user) {
        this.id = String.valueOf(user.getId());
        this.name = String.valueOf(user.getName());
        this.token = String.valueOf(user.getToken());
    }


    public String getToken() {
        return token;
    }

    public void setToken(int age) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

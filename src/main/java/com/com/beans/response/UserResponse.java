package com.com.beans.response;

import com.model.User;

public class UserResponse extends Response {
    private String id;
    private String name;
    private String email;

    public UserResponse(User user) {
        this.id = String.valueOf(user.getId());
        this.name = String.valueOf(user.getName());
        this.email = String.valueOf(user.getEmail());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

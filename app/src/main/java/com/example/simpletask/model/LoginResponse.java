package com.example.simpletask.model;

public class LoginResponse {

    private String auth;
    private User user;

    public String getAuth() { return auth; }
    public void setAuth(String value) { this.auth = value; }

    public User getUser() { return user; }
    public void setUser(User value) { this.user = value; }
}

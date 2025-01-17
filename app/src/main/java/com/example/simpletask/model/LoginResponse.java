package com.example.simpletask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class LoginResponse {


    private String auth;
    private User user;

    @XmlElement(name = "auth")
    public String getAuth() { return auth; }
    public void setAuth(String value) { this.auth = value; }

    @XmlElement(name = "user")
    public User getUser() { return user; }
    public void setUser(User value) { this.user = value; }
}

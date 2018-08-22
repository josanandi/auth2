package com.greenfoxacademy.auth2.models;

import org.springframework.stereotype.Component;

@Component
public class JwtUser {
    private String email;
    private String password;

    public JwtUser() {
    }

    public JwtUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

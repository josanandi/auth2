package com.greenfoxacademy.auth2.models;


import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;
    private Boolean activated;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.activated = false;
    }

    public User( String email,String password, Boolean activated) {
        this.email = email;
        this.password = password;
        this.activated = activated;
    }

    public Long getId() {
        return id;
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

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

}


package com.greenfoxacademy.auth2.service;

import com.greenfoxacademy.auth2.models.ErrorMessage;
import com.greenfoxacademy.auth2.models.User;

public interface UserService {

    public void updateUser(User actualUser);
    boolean checkIfEmailExists(String email);
    public User createNewUser(String email, String password);
    public ErrorMessage emailAlreadyExists();
    public boolean authenticate (String email, String password);

    User findUserById(Long id);
}


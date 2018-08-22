package com.greenfoxacademy.auth2.service;

import com.greenfoxacademy.auth2.models.ErrorMessage;
import com.greenfoxacademy.auth2.models.User;
import com.greenfoxacademy.auth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(String email, String password) {
        User newUser = new User(email, password, false);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void updateUser(User actualUser) {
        actualUser.setActivated(true);
        userRepository.save(actualUser);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public ErrorMessage emailAlreadyExists() {
        return new ErrorMessage("There is already an account with this email address in our database");
    }
    public boolean authenticate(String email, String passWord)
    {
        User user = userRepository.findUserByEmail(email);
        if (null!=user)
        {
            return user.getPassword().equals(passWord);
        }
        return false;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

}

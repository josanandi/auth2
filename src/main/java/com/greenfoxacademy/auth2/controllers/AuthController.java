package com.greenfoxacademy.auth2.controllers;

import com.greenfoxacademy.auth2.models.ErrorMessage;
import com.greenfoxacademy.auth2.models.User;
import com.greenfoxacademy.auth2.service.JwtService;
import com.greenfoxacademy.auth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
public class AuthController {
    UserService userService;
    JwtService jwtService;

    @Autowired
    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("api/user")
    public ResponseEntity<Object> registration(@RequestBody(required = false) User user){
        if (userService.checkIfEmailExists(user.getEmail())){
            ErrorMessage emailAlreadyExists = userService.emailAlreadyExists();
            return new ResponseEntity<>(emailAlreadyExists, HttpStatus.BAD_REQUEST);
        }
        else {
            User newUser = userService.createNewUser(user.getEmail(), user.getPassword());
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
    }


    @PostMapping(value = "/api/auth")
    public ResponseEntity<?> auth(@RequestBody User user) {
        String userName = user.getEmail();
        String passWord = user.getPassword();
        Boolean correctCredentials = userService.authenticate(userName, passWord);
        if (correctCredentials) {
            return ResponseEntity.ok(jwtService.getToken(user));
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }


    @GetMapping(value = "/api/secure/profile/{id}")
    public ResponseEntity<?> helloSecure(@PathVariable Long id)
    {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);

    }

}

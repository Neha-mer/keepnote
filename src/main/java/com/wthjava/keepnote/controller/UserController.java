package com.wthjava.keepnote.controller;

import com.wthjava.keepnote.dto.User;
import com.wthjava.keepnote.service.UserService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){

        boolean isAuthenticated=userService.authenticate(user.getUsername(), user.getPassword());
        return isAuthenticated?ResponseEntity.status(HttpStatus.OK).body("Authenticated"):ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authenticated");

    }
    @PostMapping("/register")
    public User reisterUser(@RequestBody User user){
       return userService.registrUser(user.getUsername(),  user.getPassword());
    }

}

package com.wthjava.keepnote.service;

import com.wthjava.keepnote.dto.User;
import com.wthjava.keepnote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {

        return userRepository.findByUsername(username).map(s->s.getPassword().equals(password)).orElse(false);
    }

    public User registrUser(String username, String password)
    {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }




}

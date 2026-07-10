package com.trivikram.springbootdemo.service;

import com.trivikram.springbootdemo.entity.User;
import com.trivikram.springbootdemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository=repository;
        this.passwordEncoder=passwordEncoder;
    }

    public User register(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole("USER");

        return repository.save(user);
    }
}

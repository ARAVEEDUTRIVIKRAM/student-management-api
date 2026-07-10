package com.trivikram.springbootdemo.Controller;


import com.trivikram.springbootdemo.entity.User;
import com.trivikram.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping("/register")
    public User register(User user){
        return service.register(user);
    }
}

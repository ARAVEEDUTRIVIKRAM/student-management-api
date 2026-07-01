package com.trivikram.springbootdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return " Hi Trivikram, Welocome to the SpringBoot World.";
    }

    @GetMapping("/greet")
    public String sayGreetings(){
        return "Good Morning Vikram, Keep coding like a champion";
    }
}

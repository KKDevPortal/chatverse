package com.kkdevportal.chatverse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Dummy endpoint to simulate user availability
     */
    @GetMapping("/health")
    public String health() {
        return "User service is running";
    }
}

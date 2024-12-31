package com.company.user_system.controller;

import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class AuthController {

    @Autowired
    public UserService userService;

    public void whatever() {
        System.out.println("Whatever");
    }
    
}

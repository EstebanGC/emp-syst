package com.company.user_system.controller;

import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.User;
import com.company.user_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {

    @Autowired
    public UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    public String singUp(
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model) {

        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");

        }
        userService.saveUser(userDto);
        return "redirect:/register?success=true";
    }

}



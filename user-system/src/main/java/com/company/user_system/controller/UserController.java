package com.company.user_system.controller;


import com.company.user_system.dto.UserDto;
import com.company.user_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/all/users")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("save/user")
    public UserDto createUser(@RequestBody UserDto userDto) throws Exception {
        return userService.saveUser(userDto);
    }

    @PutMapping("update/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("delete/user/{userId}")
    public void deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
}

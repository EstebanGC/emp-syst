package com.company.user_system.service.impl;


import com.company.user_system.dto.UserDto;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private Mapper mapper;

    public List<UserDto> findAllUsers() {
        List<UserDto> userDto = new ArrayList<>();
        userRepository. findAll().forEach(user -> userDto.add(mapper.fromEntityToUserDto(user)));

        return userDto;
    }
}

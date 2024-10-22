package com.company.user_system.service.impl;

import com.company.user_system.dto.UserDto;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.user_system.dto.Mapper;
import com.company.user_system.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(mapper::fromEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto saveUser(UserDto userDto){
        User user = mapper.fromUserDtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        return mapper.fromEntityToUserDto(savedUser);
        System.out.println("A message");
    }
}

package com.company.user_system.service;

import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto saveUser(UserDto userDto);

    User findUserByEmail(String email);

    UserDto findUserById(Long userId);

    boolean doesUserExists(Long userId);

    void updateUser(UserDto updatedUserDto, Long userId);

    void deleteUser(Long userId);
}

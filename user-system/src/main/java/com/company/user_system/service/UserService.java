package com.company.user_system.service;

import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

    User findUserByEmail(String email);

    UserDto findUserById(Long userId);

    boolean doesUserExists(Long userId);

    void editUser(UserDto updatedUserDto, Long userId);

    void deleteUserById(Long userId);
}

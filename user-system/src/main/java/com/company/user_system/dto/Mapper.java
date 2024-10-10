package com.company.user_system.dto;

import com.company.user_system.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public User fromUserDtoToEntity(UserDto userDto) {
        User user = new User();
        return user;
    }

    public UserDto fromEntityToUserDto(User user) {
        UserDto userDto = new UserDto();
        return userDto;
    }
}

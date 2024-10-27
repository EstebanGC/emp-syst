package com.company.user_system.dto;

import com.company.user_system.entity.Role;
import com.company.user_system.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {
    public User fromUserDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        if (userDto.getRole() != null){
            user.setRole(fromRoleDtoToEntity(userDto.getRole()));
        }

        return user;
    }

    public UserDto fromEntityToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        System.out.println("Whatever");

        if (user.getRole() != null) {
            userDto.setRole(fromEntityToRoleDto(user.getRole()));
        }

        return userDto;
    }

    public Role fromRoleDtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleId(roleDto.getRoleId());
        role.setName(roleDto.getName());
        return role;
    }

    public RoleDto fromEntityToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(role.getRoleId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}

package com.company.user_system.dto;

import com.company.user_system.entity.Role;
import com.company.user_system.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Mapper {

    public UserDto fromEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setRoleId(user.getRoleId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User fromDtoToEntity(UserDto userDto){
        User user = new User();
        user.setRoleId(userDto.getRoleId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public Role fromRoleDtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleId(roleDto.getRoleId());
        role.setName(roleDto.getName());
        List<User> users = new ArrayList<>();
        return role;
    }

    public RoleDto fromEntityToRoleDto(Role role) {
        List<UserDto> users = new ArrayList<>();
        role.getUsers().forEach(user -> users.add(this.fromEntityToDto(user)));
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(role.getRoleId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}

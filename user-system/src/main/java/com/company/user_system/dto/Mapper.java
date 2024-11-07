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
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        if (user.getRole() != null) {
            userDto.setRoleId(user.getRole().getRoleId());
        }
        return userDto;
    }

    public User fromDtoToEntity(UserDto userDto, Role role){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        if (role != null) {
            user.setRole(role);
        }
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

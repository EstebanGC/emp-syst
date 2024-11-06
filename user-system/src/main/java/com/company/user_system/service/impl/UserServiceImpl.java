package com.company.user_system.service.impl;

import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.Role;
import com.company.user_system.entity.User;
import com.company.user_system.repository.RoleRepository;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.UserService;
import com.company.user_system.util.BadArgumentsException;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.user_system.dto.Mapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> userDto = new ArrayList<>();
        userRepository.findAll()
                .forEach(user -> userDto.add(mapper.fromEntityToDto(user)));
        return userDto;
    }

    @Override
    public UserDto saveUser(UserDto userDto)  {
       Role role = roleRepository.findById(userDto.getRoleId())
               .orElseThrow(() -> new BadArgumentsException("Role not found"));

       return mapper.fromEntityToDto(userRepository.save(mapper.fromDtoToEntity(userDto, role)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Role role = roleRepository.findById(userDto.getRoleId())
                .orElseThrow(() -> new BadArgumentsException("Role not found"));

        return mapper.fromEntityToDto(userRepository.save(mapper.fromDtoToEntity(userDto, role)));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        System.out.println("User deleted correctly");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BadArgumentsException("User not found with email: " + email));
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadArgumentsException("User not found with ID: " + userId));
        return mapper.fromEntityToDto(user);
    }

    @Override
    public boolean doesUserExists(Long userId) {
        return userRepository.existsById(userId);
    }
}

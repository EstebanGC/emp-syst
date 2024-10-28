package com.company.user_system.service.impl;

import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.Role;
import com.company.user_system.repository.RoleRepository;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.UserService;
import com.company.user_system.util.BadArgumentsException;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.user_system.dto.Mapper;
import com.company.user_system.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                .stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList());
        return userDto;
    }

    @Override
    public UserDto saveUser(UserDto userDto) Exception {
        Optional<Role> roleResponse = roleRepository.findById(userDto.getRoleId());

        if (!roleResponse.isPresent()) {
            throw new Exception("Role not found");
        }

        User user = mapper.fromDtoToEntity(userDto, roleResponse.get());


        User savedUser = userRepository.save(user);
        return mapper.fromEntityToDto(savedUser);
    }


}

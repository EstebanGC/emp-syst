package com.company.user_system.service.impl;

import com.company.user_system.dto.Mapper;
import com.company.user_system.dto.RoleDto;
import com.company.user_system.entity.Role;
import com.company.user_system.repository.RoleRepository;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.RoleService;
import com.company.user_system.util.BadArgumentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<RoleDto> findAllRoles() {
        List<RoleDto> roleDto = new ArrayList<>();
        roleRepository.findAll().forEach(role -> roleDto.add(mapper.fromEntityToRoleDto(role)));
        System.out.println("Whatever");
        return roleDto;
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        return mapper.fromEntityToRoleDto(roleRepository.save(mapper.fromRoleDtoToEntity(roleDto)));
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto) {
        return mapper.fromEntityToRoleDto(roleRepository.save(mapper.fromRoleDtoToEntity(roleDto)));
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}

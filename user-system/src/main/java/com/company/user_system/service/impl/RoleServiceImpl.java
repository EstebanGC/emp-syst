package com.company.user_system.service.impl;

import com.company.user_system.dto.Mapper;
import com.company.user_system.dto.RoleDto;
import com.company.user_system.repository.RoleRepository;
import com.company.user_system.repository.UserRepository;
import com.company.user_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

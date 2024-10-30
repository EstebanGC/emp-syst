package com.company.user_system.service;

import com.company.user_system.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAllRoles();

    RoleDto saveRole(RoleDto roleDto);

    RoleDto updateRole(RoleDto roleDto);

    void deleteRole(Long id);
}

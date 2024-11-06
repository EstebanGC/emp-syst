package com.company.user_system.controller;

import com.company.user_system.dto.RoleDto;
import com.company.user_system.dto.UserDto;
import com.company.user_system.entity.Role;
import com.company.user_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/get/all/roles")
    public List<RoleDto> getAllRoles() {
        return roleService.findAllRoles();
    }

    @PostMapping("/save/role")
    public RoleDto saveRole(@RequestBody RoleDto roleDto) {
        return roleService.saveRole(roleDto);
    }

    @PutMapping("update/role")
    public RoleDto updateRole(@RequestBody RoleDto roleDto){
        return roleService.updateRole(roleDto);
    }

    @DeleteMapping("/delete/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
 }

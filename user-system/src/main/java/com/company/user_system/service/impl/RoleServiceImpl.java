package com.company.user_system.service.impl;

import com.company.user_system.repository.RoleRepository;
import com.company.user_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;



}

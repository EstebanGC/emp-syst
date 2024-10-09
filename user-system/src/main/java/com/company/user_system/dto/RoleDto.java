package com.company.user_system.dto;

import jakarta.validation.constraints.NotBlank;

public class RoleDto {

    private Long roleID;

    @NotBlank
    private String name;
}

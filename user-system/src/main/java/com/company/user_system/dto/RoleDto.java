package com.company.user_system.dto;

import com.company.user_system.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long roleId;

    @NotBlank
    private String name;

    private List<UserDto> users;
}

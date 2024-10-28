package com.company.user_system.dto;


import com.company.user_system.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;

    @NotBlank(message="Username should not be empty")
    private String username;

    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotNull(message = "Password should not be empty")
    private String password;

    private Long roleId;
}

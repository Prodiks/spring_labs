package com.example.lab_7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should be not empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;
}

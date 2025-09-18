package com.fb_challenge.api.user.presentation.dto;

import com.fb_challenge.api.shared.infrastructure.validator.cpf.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {
    @Size(min = 3, max = 255)
    private String name;

    @Email
    @Size(min = 3, max = 100)
    private String email;

    @CPF
    private String cpf;

    @Size(min = 8, max = 255)
    private String password;
}

package com.example.ForumHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "O email não pode estar vazio")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "A senha não pode estar vazia")
        String senha
) {}

package com.example.ForumHub.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistroDto(
        @NotBlank String email,
        @NotBlank String senha,
        @NotBlank String nome) {
}

package br.com.alura.challange_forum_hub.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserDTO(
        @NotBlank
        String username,
        @NotBlank
        @Email(message = "Formato de email inválido")
        String email,
        @NotBlank
        String password
) {
}

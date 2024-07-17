package br.com.alura.challange_forum_hub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}

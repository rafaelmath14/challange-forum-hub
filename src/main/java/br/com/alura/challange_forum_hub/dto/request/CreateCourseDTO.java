package br.com.alura.challange_forum_hub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseDTO(@NotBlank
                              String name,
                              @NotBlank
                              String category) {
}

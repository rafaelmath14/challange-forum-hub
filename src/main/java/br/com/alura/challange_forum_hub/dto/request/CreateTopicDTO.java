package br.com.alura.challange_forum_hub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long course_id
) {
}

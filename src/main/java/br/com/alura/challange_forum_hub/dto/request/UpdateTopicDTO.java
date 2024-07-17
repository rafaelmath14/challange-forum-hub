package br.com.alura.challange_forum_hub.dto.request;

import br.com.alura.challange_forum_hub.domain.TopicStatus;

public record UpdateTopicDTO(String title, String message, Long course_id, TopicStatus status) {
}

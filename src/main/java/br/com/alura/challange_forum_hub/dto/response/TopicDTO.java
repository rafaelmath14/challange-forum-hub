package br.com.alura.challange_forum_hub.dto.response;

import br.com.alura.challange_forum_hub.domain.Topic;
import br.com.alura.challange_forum_hub.domain.TopicStatus;

import java.time.LocalDate;

public record TopicDTO(Long id,
                       String title,
                       String message,
                       TopicStatus status,
                       CourseDTO course,
                       String author,
                       LocalDate createdDate) {
    public TopicDTO(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getTopicStatus(), new CourseDTO(topic.getCourse()), topic.getAuthor().getUsername(), topic.getCreateDate());
    }
}

package br.com.alura.challange_forum_hub.repository;

import br.com.alura.challange_forum_hub.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleAndMessage(String title, String message);
}

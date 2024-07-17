package br.com.alura.challange_forum_hub.repository;

import br.com.alura.challange_forum_hub.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

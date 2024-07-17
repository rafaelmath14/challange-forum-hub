package br.com.alura.challange_forum_hub.dto.response;

import br.com.alura.challange_forum_hub.domain.Course;

public record CourseDTO(Long id,
                        String name,
                        String category) {
    public CourseDTO(Course course){
        this(course.getId(), course.getName(), course.getCategory());
    }

}

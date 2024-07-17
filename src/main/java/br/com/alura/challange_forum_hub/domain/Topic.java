package br.com.alura.challange_forum_hub.domain;

import br.com.alura.challange_forum_hub.dto.request.CreateTopicDTO;
import br.com.alura.challange_forum_hub.dto.request.UpdateTopicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private TopicStatus topicStatus;

    @Setter
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Setter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Transient
    private List<Answer> answers;

    public Topic(CreateTopicDTO data, Course course, User author) {
        this.title = data.title();
        this.message = data.message();
        this.course = course;
        this.author = author;
        this.topicStatus = TopicStatus.OPEN;
        this.createDate = LocalDate.now();
    }

    public void update(UpdateTopicDTO data, Course course) {
        if (data.title() != null){
            this.title = data.title();
        }
        if (data.message() != null) {
            this.message = data.message();
        }
        if (data.course_id() != null) {
            this.course = course;
        }
        if (data.status() != null) {
            this.topicStatus = data.status();
        }
    }



}

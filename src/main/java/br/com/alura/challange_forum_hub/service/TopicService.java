package br.com.alura.challange_forum_hub.service;

import br.com.alura.challange_forum_hub.domain.Course;
import br.com.alura.challange_forum_hub.domain.Topic;
import br.com.alura.challange_forum_hub.domain.TopicStatus;
import br.com.alura.challange_forum_hub.dto.request.CreateTopicDTO;
import br.com.alura.challange_forum_hub.dto.request.UpdateTopicDTO;
import br.com.alura.challange_forum_hub.repository.CourseRepository;
import br.com.alura.challange_forum_hub.repository.TopicRepository;
import br.com.alura.challange_forum_hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Topic registerTopic(CreateTopicDTO data, String loggedUser) throws Exception {

        if (!courseRepository.existsById(data.course_id())) {
            throw new Exception("O curso informado não foi encontrado.");
        }

        if (topicRepository.existsByTitleAndMessage(data.title(), data.message())){
            throw new Exception("Falha ao registrar, este tópico já existe");
        }

        var author = userRepository.getReferenceByUsername(loggedUser);
        var course = courseRepository.getReferenceById(data.course_id());

        return new Topic(data, course, author);
    }

    public Topic updateTopic(UpdateTopicDTO data, String loggedUser, Long topicId) throws Exception {
        var topic = topicRepository.getReferenceById(topicId);
        Course course = topic.getCourse();

        // Verifica se a requisição veio do autor do tópico
        if (!topic.getAuthor().getUsername().equals(loggedUser)){
            throw new Exception("Não foi possivel alterar o tópico, pois a requisição não veio do autor");
        }

        // Verifica se o curso enderaçado ao tópico existe no sistema
        if (data.course_id() != null) {
            if (!courseRepository.existsById(data.course_id())){
                throw new Exception("O curso informado não foi encontrado.");
            }

            course = courseRepository.getReferenceById(data.course_id());
        }

        // Verifica se o novo tópico não é uma cópia de outro.
        if (data.title() != null || data.message() != null){
            String title = data.title() != null ? data.title() : topic.getTitle();
            String message = data.message() != null ? data.message() : topic.getMessage();

            if (topicRepository.existsByTitleAndMessage(title, message)){
                throw new Exception("Falha ao registrar, este tópico já existe");
            }
        }

        // Usuários não podem mudar o status do próprio tópico para reportado.
        if (data.status() != null) {
            if (data.status().equals(TopicStatus.REPORTED)){
                throw new Exception("Você não tem permissão para fazer esta alteração no status do tópico.");
            }
        }

        topic.update(data, course);
        return topic;
    }

    public Topic deleteTopic(String loggedUser, Long topicId) throws Exception {
        var topic = topicRepository.getReferenceById(topicId);

        if (!topic.getAuthor().getUsername().equals(loggedUser)){
            throw new Exception("Não foi possivel alterar o tópico, pois a requisição não veio do autor");
        }

        return topic;
    }

}

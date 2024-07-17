package br.com.alura.challange_forum_hub.domain;

import org.apache.catalina.User;

import java.time.LocalDateTime;

public class Answer {
    private Long id;
    private String message;
private Topic topic;
private LocalDateTime creatDate;
private User author;
private boolean solution;
}

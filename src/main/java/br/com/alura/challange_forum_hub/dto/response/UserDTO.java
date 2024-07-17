package br.com.alura.challange_forum_hub.dto.response;

import br.com.alura.challange_forum_hub.domain.User;

public record UserDTO(
        Long id,
        String username,
        String email
) {
    public UserDTO(User user){
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}

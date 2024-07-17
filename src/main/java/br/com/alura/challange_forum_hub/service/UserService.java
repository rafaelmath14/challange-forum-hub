package br.com.alura.challange_forum_hub.service;

import br.com.alura.challange_forum_hub.domain.User;
import br.com.alura.challange_forum_hub.dto.request.RegisterUserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User registerUser(RegisterUserDTO dto){
        var encoder = new BCryptPasswordEncoder();
        var encodedPassword = encoder.encode(dto.password());

        var user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(encodedPassword);
        user.setActive(true);

        return user;
    }
}


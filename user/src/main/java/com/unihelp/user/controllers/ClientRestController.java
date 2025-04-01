package com.unihelp.user.controllers;

import com.unihelp.user.entities.User;
import com.unihelp.user.repositories.UserRepository;
import com.unihelp.user.security.JwtUtils;
import com.unihelp.user.services.UserService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

@RequestMapping("/api/auth")

public class ClientRestController {
    private final UserRepository userRepository;

    public ClientRestController( UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> userList(){

        return userRepository.findAll();
    }


    @GetMapping("/users/{id}")
    public User userById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }


}

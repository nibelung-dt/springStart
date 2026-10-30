package com.example.demo.controllers;

import com.example.demo.UserEntity;
import com.example.demo.UserRepository;
import com.example.demo.models.User;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get_user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userRepository.findById(id)
                .map(entity -> ResponseEntity.ok(new User(entity.getId(), entity.getName())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/get_all_users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll().stream()
                .map(entity -> new User(entity.getId(), entity.getName()))
                .toList();

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }


    @PostMapping("/put_user")
    public User putUser(@RequestBody @Valid User user) {
        log.info("user = {}", user);

        UserEntity entity = new UserEntity();
        entity.setId(user.id());
        entity.setName(user.name());

        UserEntity saved = userRepository.save(entity);

        return new User(saved.getId(), saved.getName());
    }
}

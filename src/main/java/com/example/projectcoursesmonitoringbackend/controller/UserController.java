package com.example.projectcoursesmonitoringbackend.controller;

import com.example.projectcoursesmonitoringbackend.model.User;
import com.example.projectcoursesmonitoringbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/email/{email}")
    public Boolean checkIfEmailExists(@PathVariable String email) {
        boolean emailExists = userService.emailExists(email);
        log.info("User with email: '{}' - exists: '{}'", email, emailExists);
        return emailExists;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        log.info("User: {} was created", user);
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }

}

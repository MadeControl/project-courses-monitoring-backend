package com.example.projectcoursesmonitoringbackend.service.impl;

import com.example.projectcoursesmonitoringbackend.exception.NotFoundException;
import com.example.projectcoursesmonitoringbackend.model.Role;
import com.example.projectcoursesmonitoringbackend.model.User;
import com.example.projectcoursesmonitoringbackend.repository.UserRepository;
import com.example.projectcoursesmonitoringbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User was not found by Email ";
    private final Role DEFAULT_ROLE = Role.STUDENT;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public User createUser(User user) {
        user.setRole(DEFAULT_ROLE);
        user.setCreated(new Date());
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE + email));
    }
}

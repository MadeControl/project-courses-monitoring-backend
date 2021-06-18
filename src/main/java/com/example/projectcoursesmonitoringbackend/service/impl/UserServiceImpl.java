package com.example.projectcoursesmonitoringbackend.service.impl;

import com.example.projectcoursesmonitoringbackend.model.Role;
import com.example.projectcoursesmonitoringbackend.model.User;
import com.example.projectcoursesmonitoringbackend.repository.UserRepository;
import com.example.projectcoursesmonitoringbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

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
}

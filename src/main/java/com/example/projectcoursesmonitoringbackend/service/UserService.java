package com.example.projectcoursesmonitoringbackend.service;

import com.example.projectcoursesmonitoringbackend.model.User;

public interface UserService {

    boolean emailExists(String email);

    User createUser(User user);

    User findUserByEmail(String email);
}

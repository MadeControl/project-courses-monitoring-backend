package com.example.projectcoursesmonitoringbackend.mapper;

import com.example.projectcoursesmonitoringbackend.dto.AuthorDTO;
import com.example.projectcoursesmonitoringbackend.model.User;

public class AuthorMapper {

    public AuthorDTO mapModelToDTO(User author) {
        String name = author.getFirstname() + " " + author.getLastname();
        return new AuthorDTO(author.getId(), name);
    }

}

package com.example.projectcoursesmonitoringbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationDTO {
    private String username;
    private String password;
}

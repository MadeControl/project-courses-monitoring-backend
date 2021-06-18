package com.example.projectcoursesmonitoringbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;

}

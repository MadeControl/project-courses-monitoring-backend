package com.example.projectcoursesmonitoringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCardDTO {

    private Long id;
    private String title;
    private AuthorDTO author;
    private String previewDescription;
    private String iconName;

    private Long gradesQuantity;
    private Long averageGrade;
}

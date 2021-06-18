package com.example.projectcoursesmonitoringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private String previewDescription;

    private Long studentsQuantity;
    private Long gradesQuantity;
    private Long averageGrade;

    private AuthorDTO author;
    private String iconName;

    private Date created;
    private Date started;
    private Date finished;

    private List<CourseRequirementDTO> requirements;

    private String fullDescription;

    private List<VideoDTO> videos;
}

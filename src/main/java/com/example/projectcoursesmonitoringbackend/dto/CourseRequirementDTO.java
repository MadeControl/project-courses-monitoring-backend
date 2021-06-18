package com.example.projectcoursesmonitoringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequirementDTO {

    private String text;
    private Long number;
}

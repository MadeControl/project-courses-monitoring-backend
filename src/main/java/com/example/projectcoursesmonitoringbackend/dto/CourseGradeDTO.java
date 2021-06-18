package com.example.projectcoursesmonitoringbackend.dto;

import com.example.projectcoursesmonitoringbackend.model.GradeMaker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseGradeDTO {

    private Long id;
    private Long gradeMakerId;
    private Long courseId;
    private Long grade;
    private GradeMaker gradedBy;
}

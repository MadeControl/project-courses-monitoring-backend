package com.example.projectcoursesmonitoringbackend.mapper;

import com.example.projectcoursesmonitoringbackend.dto.CourseRequirementDTO;
import com.example.projectcoursesmonitoringbackend.model.CourseRequirement;

import java.util.List;
import java.util.stream.Collectors;

public class CourseRequirementMapper {

    public List<CourseRequirementDTO> mapModelToDTO(List<CourseRequirement> courseRequirements) {
        return courseRequirements.stream()
                .map(requirement -> new CourseRequirementDTO(
                        requirement.getText(),
                        requirement.getNumber()
                ))
                .collect(Collectors.toList());
    }

}

package com.example.projectcoursesmonitoringbackend.service;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseCardDTO> getAllCoursesCards();

    CourseDTO getCourseById(Long id);

}

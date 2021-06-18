package com.example.projectcoursesmonitoringbackend.service;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseGradeDTO;
import com.example.projectcoursesmonitoringbackend.dto.ThemeDTO;

import java.util.List;

public interface CourseService {

    List<CourseCardDTO> getAllCoursesCards();

    CourseDTO getCourseById(Long id);

    void createGrade(CourseGradeDTO grade);

    List<ThemeDTO> getAllThemes();

}

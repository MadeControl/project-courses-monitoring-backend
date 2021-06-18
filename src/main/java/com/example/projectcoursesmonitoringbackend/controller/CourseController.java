package com.example.projectcoursesmonitoringbackend.controller;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseGradeDTO;
import com.example.projectcoursesmonitoringbackend.dto.ThemeDTO;
import com.example.projectcoursesmonitoringbackend.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseCardDTO>> getAllCourseCards() {
        List<CourseCardDTO> courseCards = courseService.getAllCoursesCards();
        return new ResponseEntity<>(courseCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/grade")
    public ResponseEntity<?> createGrade(@RequestBody CourseGradeDTO gradeDTO) {
        courseService.createGrade(gradeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/themes")
    public ResponseEntity<List<ThemeDTO>> getAllThemes() {
        List<ThemeDTO> themes = courseService.getAllThemes();
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }
}

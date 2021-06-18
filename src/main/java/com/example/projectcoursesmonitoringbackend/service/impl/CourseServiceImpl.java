package com.example.projectcoursesmonitoringbackend.service.impl;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;
import com.example.projectcoursesmonitoringbackend.exception.NotFoundException;
import com.example.projectcoursesmonitoringbackend.mapper.CourseCardMapper;
import com.example.projectcoursesmonitoringbackend.mapper.CourseMapper;
import com.example.projectcoursesmonitoringbackend.model.Course;
import com.example.projectcoursesmonitoringbackend.repository.CourseRepository;
import com.example.projectcoursesmonitoringbackend.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseCardMapper courseCardMapper;
    private final CourseMapper courseMapper;

    private static final String COURSE_NOT_FOUND_EXCEPTION_MESSAGE = "Course was not found by ID ";

    public CourseServiceImpl(CourseRepository courseRepository, CourseCardMapper courseCardMapper, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseCardMapper = courseCardMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseCardDTO> getAllCoursesCards() {
        List<Course> courses = courseRepository.findAll();
        return courseCardMapper.mapModelToDTO(courses);
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(COURSE_NOT_FOUND_EXCEPTION_MESSAGE + id));
        CourseDTO courseDTO = courseMapper.mapModelToDTO(course);
        courseDTO.getVideos().sort((o1, o2) -> (int) (o1.getNumber() - o2.getNumber()));
        return courseDTO;
    }
}

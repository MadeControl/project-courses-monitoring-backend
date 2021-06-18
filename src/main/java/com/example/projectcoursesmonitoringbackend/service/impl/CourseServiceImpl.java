package com.example.projectcoursesmonitoringbackend.service.impl;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;
import com.example.projectcoursesmonitoringbackend.dto.CourseGradeDTO;
import com.example.projectcoursesmonitoringbackend.dto.ThemeDTO;
import com.example.projectcoursesmonitoringbackend.exception.NotFoundException;
import com.example.projectcoursesmonitoringbackend.mapper.CourseCardMapper;
import com.example.projectcoursesmonitoringbackend.mapper.CourseMapper;
import com.example.projectcoursesmonitoringbackend.model.Course;
import com.example.projectcoursesmonitoringbackend.model.CourseGrade;
import com.example.projectcoursesmonitoringbackend.model.User;
import com.example.projectcoursesmonitoringbackend.repository.CourseGradeRepository;
import com.example.projectcoursesmonitoringbackend.repository.CourseRepository;
import com.example.projectcoursesmonitoringbackend.repository.ThemeRepository;
import com.example.projectcoursesmonitoringbackend.service.CourseService;
import com.example.projectcoursesmonitoringbackend.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final UserService userService;
    private final CourseRepository courseRepository;
    private final CourseGradeRepository courseGradeRepository;
    private final ThemeRepository themeRepository;
    private final CourseCardMapper courseCardMapper;
    private final CourseMapper courseMapper;

    private static final String COURSE_NOT_FOUND_EXCEPTION_MESSAGE = "Course was not found by ID ";

    public CourseServiceImpl(UserService userService, CourseRepository courseRepository, CourseGradeRepository courseGradeRepository, ThemeRepository themeRepository, CourseCardMapper courseCardMapper, CourseMapper courseMapper) {
        this.userService = userService;
        this.courseRepository = courseRepository;
        this.courseGradeRepository = courseGradeRepository;
        this.themeRepository = themeRepository;
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

    @Override
    public void createGrade(CourseGradeDTO gradeDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        User user = userService.findUserByEmail(userPrincipal.getUsername());
        Course course = courseRepository.findById(gradeDTO.getCourseId())
                .orElseThrow(() -> new NotFoundException(COURSE_NOT_FOUND_EXCEPTION_MESSAGE + gradeDTO.getCourseId()));
        CourseGrade grade = courseGradeRepository
                .findCourseGradeByCourseIdAndUserId(course.getId(), user.getId())
                .orElseGet(() -> new CourseGrade(
                        gradeDTO.getId(),
                        course,
                        user,
                        gradeDTO.getGrade(),
                        gradeDTO.getGradedBy()
                ));
        grade.setGrade(gradeDTO.getGrade());
        courseGradeRepository.save(grade);
    }

    @Override
    public List<ThemeDTO> getAllThemes() {
        return themeRepository.findAll().stream()
                .map(t -> new ThemeDTO(t.getId(), t.getTitle()))
                .collect(Collectors.toList());
    }
}

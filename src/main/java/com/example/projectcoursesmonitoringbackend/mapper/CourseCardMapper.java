package com.example.projectcoursesmonitoringbackend.mapper;

import com.example.projectcoursesmonitoringbackend.dto.CourseCardDTO;
import com.example.projectcoursesmonitoringbackend.model.Course;
import com.example.projectcoursesmonitoringbackend.model.CourseGrade;

import java.util.List;
import java.util.stream.Collectors;

public class CourseCardMapper {

    private final AuthorMapper authorMapper;

    public CourseCardMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public List<CourseCardDTO> mapModelToDTO(List<Course> courses) {
        return courses.stream()
                .map(course -> new CourseCardDTO(
                        course.getId(),
                        course.getTitle(),
                        authorMapper.mapModelToDTO(course.getAuthor()),
                        course.getPreviewDescription(),
                        course.getIconName(),
                        (long) course.getGrades().size(),
                        calculateAverageGrade(course)
                ))
                .collect(Collectors.toList());
    }

    private long calculateAverageGrade(Course course) {
        long averageGrade = 0;
        if(!course.getGrades().isEmpty()) {
            averageGrade = course.getGrades().stream().mapToLong(CourseGrade::getGrade).sum() / course.getGrades().size();
        }
        return averageGrade;
    }

}

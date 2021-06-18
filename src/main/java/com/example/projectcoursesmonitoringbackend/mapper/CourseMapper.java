package com.example.projectcoursesmonitoringbackend.mapper;

import com.example.projectcoursesmonitoringbackend.dto.CourseDTO;
import com.example.projectcoursesmonitoringbackend.model.Course;
import com.example.projectcoursesmonitoringbackend.model.CourseGrade;

public class CourseMapper {

    private final AuthorMapper authorMapper;
    private final CourseRequirementMapper courseRequirementMapper;
    private final VideoMapper videoMapper;

    public CourseMapper(AuthorMapper authorMapper, CourseRequirementMapper courseRequirementMapper, VideoMapper videoMapper) {
        this.authorMapper = authorMapper;
        this.courseRequirementMapper = courseRequirementMapper;
        this.videoMapper = videoMapper;
    }

    public CourseDTO mapModelToDTO(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getPreviewDescription(),
                (long) course.getStudents().size(),
                (long) course.getGrades().size(),
                calculateAverageGrade(course),
                authorMapper.mapModelToDTO(course.getAuthor()),
                course.getIconName(),
                course.getCreated(),
                course.getStarted(),
                course.getFinished(),
                courseRequirementMapper.mapModelToDTO(course.getRequirements()),
                course.getFullDescription(),
                videoMapper.mapModelToDTO(course.getVideos()
                )
        );
    }

    private long calculateAverageGrade(Course course) {
        long averageGrade = 0;
        if(!course.getGrades().isEmpty()) {
            averageGrade = course.getGrades().stream().mapToLong(CourseGrade::getGrade).sum() / course.getGrades().size();
        }
        return averageGrade;
    }

}

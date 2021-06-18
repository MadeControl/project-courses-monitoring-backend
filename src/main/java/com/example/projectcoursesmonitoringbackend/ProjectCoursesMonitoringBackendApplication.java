package com.example.projectcoursesmonitoringbackend;

import com.example.projectcoursesmonitoringbackend.mapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectCoursesMonitoringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectCoursesMonitoringBackendApplication.class, args);
    }

    @Bean
    public AuthorMapper authorMapper() {
        return new AuthorMapper();
    }

    @Bean
    public CourseCardMapper courseCardMapper() {
        return new CourseCardMapper(authorMapper());
    }

    @Bean
    public VideoMapper videoMapper() {
        return new VideoMapper();
    }

    @Bean
    public CourseRequirementMapper courseRequirementMapper() { return new CourseRequirementMapper(); }

    @Bean
    public CourseMapper courseMapper() { return new CourseMapper(authorMapper(), courseRequirementMapper(), videoMapper()); }

}

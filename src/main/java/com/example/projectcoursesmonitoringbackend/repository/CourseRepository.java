package com.example.projectcoursesmonitoringbackend.repository;

import com.example.projectcoursesmonitoringbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

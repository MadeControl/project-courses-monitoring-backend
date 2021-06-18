package com.example.projectcoursesmonitoringbackend.repository;

import com.example.projectcoursesmonitoringbackend.model.CourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseGradeRepository extends JpaRepository<CourseGrade, Long> {
    @Query("SELECT g FROM CourseGrade g WHERE g.course.id = ?1 AND g.student.id = ?2")
    Optional<CourseGrade> findCourseGradeByCourseIdAndUserId(Long courseId, Long studentId);
}

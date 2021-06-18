package com.example.projectcoursesmonitoringbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grade", schema = "public")
public class CourseGrade {

    @Id
    @GeneratedValue
    @Column(name = "grade_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    private Long grade;

    @Enumerated(EnumType.STRING)
    private GradeMaker gradedBy;
}

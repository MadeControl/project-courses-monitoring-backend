package com.example.projectcoursesmonitoringbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "requirement", schema = "public")
public class CourseRequirement {

    @Id
    @GeneratedValue
    @Column(name = "requirement_id")
    private long id;

    private String text;
    private Long number;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}

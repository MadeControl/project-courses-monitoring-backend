package com.example.projectcoursesmonitoringbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean banned;

    @OneToMany(mappedBy = "author")
    private List<Course> createdCourses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> followedCourses;

    private Date created;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<CourseGrade> grades;
}

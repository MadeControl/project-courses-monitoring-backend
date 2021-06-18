package com.example.projectcoursesmonitoringbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "public")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> students;

    private Date created;
    private Date started;
    private Date finished;

    private String previewDescription;
    private String fullDescription;

    private String iconName;

    @OneToMany(mappedBy = "course")
    private List<CourseRequirement> requirements;

    @OneToMany(mappedBy = "course")
    private List<Video> videos;

    @OneToMany(mappedBy = "course")
    private List<CourseGrade> grades;
}

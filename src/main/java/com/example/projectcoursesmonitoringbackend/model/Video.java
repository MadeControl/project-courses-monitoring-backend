package com.example.projectcoursesmonitoringbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "video", schema = "public")
public class Video {

    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;
    private Long number;
    private String title;
    private Long duration;
    private String url;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

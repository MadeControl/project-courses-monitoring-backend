package com.example.projectcoursesmonitoringbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "public")
public class Theme {

    @Id
    @GeneratedValue
    @Column(name = "theme_id")
    private long id;

    private String title;

}

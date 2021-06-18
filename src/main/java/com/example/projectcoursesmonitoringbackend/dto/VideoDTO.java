package com.example.projectcoursesmonitoringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {

    private Long number;
    private String title;
    private Long duration;
    private String url;
}

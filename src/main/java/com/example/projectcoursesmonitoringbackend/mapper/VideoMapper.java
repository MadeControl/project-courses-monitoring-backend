package com.example.projectcoursesmonitoringbackend.mapper;

import com.example.projectcoursesmonitoringbackend.dto.VideoDTO;
import com.example.projectcoursesmonitoringbackend.model.Video;

import java.util.List;
import java.util.stream.Collectors;

public class VideoMapper {

    public List<VideoDTO> mapModelToDTO(List<Video> videos) {
        return videos.stream()
                .map(video -> new VideoDTO(
                        video.getNumber(),
                        video.getTitle(),
                        video.getDuration(),
                        video.getUrl()
                ))
                .collect(Collectors.toList());
    }

}

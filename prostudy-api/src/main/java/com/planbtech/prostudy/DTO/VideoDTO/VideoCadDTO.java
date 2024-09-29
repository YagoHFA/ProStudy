package com.planbtech.prostudy.DTO.VideoDTO;

import com.planbtech.prostudy.entities.model.Video;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoCadDTO {
    private String videoId;
    private String videoTitle;
    private String thumb;
    private String category;

    public VideoCadDTO(Video entity) {
        this.videoId = entity.getVideoId();
        this.videoTitle = entity.getVideoTitle();
        this.thumb = entity.getVideoThumbnail();
        this.category = entity.getCategory().getCategoryName();
    }
}

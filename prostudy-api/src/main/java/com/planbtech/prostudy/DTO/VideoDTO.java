package com.planbtech.prostudy.DTO;


import com.planbtech.prostudy.entities.model.Video;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {

    private String videoId;
    private String videoTitle;
    private String thumb;

    public VideoDTO(Video entity) {
        this.videoId = entity.getVideoId();
        this.videoTitle = entity.getVideoTitle();
        this.thumb = entity.getVideoThumbnail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoDTO videoDTO)) return false;

        if (!getVideoId().equals(videoDTO.getVideoId())) return false;
        return getVideoTitle().equals(videoDTO.getVideoTitle());
    }

    @Override
    public int hashCode() {
        int result = getVideoId().hashCode();
        result = 31 * result + getVideoTitle().hashCode();
        return result;
    }
}

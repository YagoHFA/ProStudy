package com.planbtech.prostudy.DTO;


import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.entities.model.Video;

public class VideoDTO {

    private String videoId;
    private String videoTitle;

    public VideoDTO(Video entity) {
        this.videoId = entity.getVideoId();
        this.videoTitle = entity.getVideoTitle();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
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

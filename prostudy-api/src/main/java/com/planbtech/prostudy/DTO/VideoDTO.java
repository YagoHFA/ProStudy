package com.planbtech.prostudy.DTO;


import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.entities.model.Video;

public class VideoDTO {

    private String videoId;
    private String videoTitle;
    private Category videoCategory;

    public VideoDTO(Video entity) {
        this.videoId = entity.getVideoId();
        this.videoTitle = entity.getVideoTitle();
        this.videoCategory = entity.getCategory();
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

    public Category getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(Category videoCategory) {
        this.videoCategory = videoCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoDTO videoDTO)) return false;

        if (!getVideoId().equals(videoDTO.getVideoId())) return false;
        if (!getVideoTitle().equals(videoDTO.getVideoTitle())) return false;
        return getVideoCategory() != null ? getVideoCategory().equals(videoDTO.getVideoCategory()) : videoDTO.getVideoCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getVideoId().hashCode();
        result = 31 * result + getVideoTitle().hashCode();
        result = 31 * result + (getVideoCategory() != null ? getVideoCategory().hashCode() : 0);
        return result;
    }
}

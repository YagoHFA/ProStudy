package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.entities.model.Video;

import java.util.List;

public class CategoryDTO {

    private Long  categoryId;
    private String categoryName;
    private List<VideoDTO> videoList;

    public CategoryDTO(Category entity) {
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategoryName();
        this.videoList = entity.getVideoList().stream().map(VideoDTO::new).toList();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<VideoDTO> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoDTO> videoList) {
        this.videoList = videoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDTO that)) return false;

        if (!getCategoryId().equals(that.getCategoryId())) return false;
        if (!getCategoryName().equals(that.getCategoryName())) return false;
        return getVideoList() != null ? getVideoList().equals(that.getVideoList()) : that.getVideoList() == null;
    }

    @Override
    public int hashCode() {
        int result = getCategoryId().hashCode();
        result = 31 * result + getCategoryName().hashCode();
        result = 31 * result + (getVideoList() != null ? getVideoList().hashCode() : 0);
        return result;
    }
}

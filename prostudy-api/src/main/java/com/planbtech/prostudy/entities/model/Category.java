package com.planbtech.prostudy.entities.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {

    @Id
    @Column(name = "categoryid")
    private Long categoryId;

    @Column(name = "categoryname")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Video> videoList;

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }
}


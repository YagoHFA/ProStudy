package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;

@Entity
public class Video  {

    @Id
    private String videoId;

    private String videoTitle;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;


    public String getVideoId() {
        return this.videoId;
    }


    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setVideoTitle(String title) {
        this.videoTitle = title;
    }


    public Category getCategory() {
        return this.category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
}

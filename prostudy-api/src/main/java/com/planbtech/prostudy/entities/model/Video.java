package com.planbtech.prostudy.entities.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "videos")
@Getter
@Setter
public class Video  {

    @Id
    @Column(name = "videoid", length = 11)
    private String videoId;

    @Column(name = "videotitle")
    private String videoTitle;

    @Column(name = "videothumb")
    private String videoThumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid")
    private Category category;

    @JsonBackReference
    public Category getCategory() {
        return category;
    }


}

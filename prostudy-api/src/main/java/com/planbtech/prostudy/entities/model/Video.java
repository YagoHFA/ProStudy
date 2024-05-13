package com.planbtech.prostudy.entities.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}

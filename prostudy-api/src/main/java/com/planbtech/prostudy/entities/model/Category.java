package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @Column(name = "categoryid")
    private Long categoryId;

    @Column(name = "categoryname")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Video> videoList;

    @ManyToMany(mappedBy = "categoryList")
    private List<SkillTest> skillTestList;
}


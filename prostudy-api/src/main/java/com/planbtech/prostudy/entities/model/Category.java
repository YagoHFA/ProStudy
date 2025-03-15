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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Video> videoList;

    @ManyToMany(mappedBy = "categoryList")
    private List<SkillTest> skillTestList;

    @ManyToMany(mappedBy = "tools")
    private List<Project> projectList;
}


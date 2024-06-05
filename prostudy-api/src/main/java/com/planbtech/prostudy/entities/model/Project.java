package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "projectid")
    private String projectId;

    @Column(name = "projectname")
    private String projectName;

    @Column(name = "projectdescription")
    private String projectDescription;

    @Column(name = "projectURL")
    private String projectURL;

    @ManyToMany(mappedBy = "userProjects")
    private List<User> projectsUser;

    @ManyToMany
    @JoinTable(name = "project_tools",
            joinColumns = @JoinColumn(name = "projectid"),
            inverseJoinColumns = @JoinColumn(name = "toolsid"))
    private List<Category> tools;

    public void generateProjectId(String projectName, String projectOwner, Long userId) {
        String projectNamePart = projectName.length() >= 3 ? projectName.substring(0, 3) : projectName;
        String projectOwnerPart = projectOwner.length() >= 2 ? projectOwner.substring(0, 2) : projectOwner;
        this.projectId  = projectNamePart.toLowerCase() + "#" + projectOwnerPart.toLowerCase() + userId;
    }
}

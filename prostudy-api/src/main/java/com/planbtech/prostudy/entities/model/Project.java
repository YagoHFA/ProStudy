package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

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

    @OneToMany(mappedBy = "id.projectId")
    private List<User_Project> ProjectsUser;

    @ManyToAny
    @JoinTable(name = "project_tools",
            joinColumns = @JoinColumn(name = "projectid"),
            inverseJoinColumns = @JoinColumn(name = "categoryid"))
    private List<Category> tools;
}

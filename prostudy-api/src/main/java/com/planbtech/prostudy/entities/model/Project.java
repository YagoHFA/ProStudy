package com.planbtech.prostudy.entities.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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

    @Column( columnDefinition = "text", name = "projectdescription")
    private String projectDescription;
}

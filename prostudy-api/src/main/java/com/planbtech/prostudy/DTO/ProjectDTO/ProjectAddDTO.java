package com.planbtech.prostudy.DTO.ProjectDTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAddDTO {

    private String projectOwner;
    private String projectName;
    private List<String> tools;
    private String shortDescription;
    private String projectURL;

}

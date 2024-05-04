package com.planbtech.prostudy.DTO.ProjectDTO;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.entities.model.Project;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMinViewDTO {

    private String projectName;
    private String projectDescription;
    private List<CategoryMinDTO> tools;

    public ProjectMinViewDTO(Project entity){
        this.projectName = entity.getProjectName();
        this.projectDescription = entity.getProjectDescription();
        this.tools = entity.getTools().stream().map(CategoryMinDTO::new).toList();
    }

}

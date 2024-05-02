package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import com.planbtech.prostudy.entities.model.Project;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.repositories.ProjectRepository;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CategoryReporitory categoryReporitory;

    @Override
    public void updateProject(ProjectUpdateDTO projectUpdateDTO){
        Project projectToUpdate = projectRepository.findById(projectUpdateDTO.getId())
                .orElseThrow();
        projectToUpdate.setProjectName(projectUpdateDTO.getTitle());
        projectToUpdate.setProjectDescription(projectUpdateDTO.getDescription());
        projectToUpdate.setTools(projectUpdateDTO.getTools().stream().map(categoryReporitory::findByCategoryName).toList());
        projectRepository.save(projectToUpdate);
    }

    @Override
    public void deleteProject(String projectId) {
        projectRepository.delete(projectRepository.findById(projectId).orElseThrow());
    }
}

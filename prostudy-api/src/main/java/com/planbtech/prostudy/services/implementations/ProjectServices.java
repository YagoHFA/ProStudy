package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import com.planbtech.prostudy.entities.model.Project;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.repositories.ProjectRepository;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CategoryReporitory categoryReporitory;

    @Transactional
    @Override
    public void updateProject(ProjectUpdateDTO projectUpdateDTO){
        Project projectToUpdate = projectRepository.findById(projectUpdateDTO.getId())
                .orElseThrow();
        projectToUpdate.setProjectName(projectUpdateDTO.getTitle());
        projectToUpdate.setProjectDescription(projectUpdateDTO.getDescription());
        projectToUpdate.setTools(projectUpdateDTO.getTools().stream().map(categoryReporitory::findByCategoryName).toList());
        projectRepository.save(projectToUpdate);
    }

    @Transactional
    @Override
    public void deleteProject(String projectId) {
        projectRepository.delete(projectRepository.findById(projectId).orElseThrow());
    }

    @Transactional
    @Override
    public ProjectMinViewDTO findById(String projectId) {
        return projectRepository.findById(projectId).map(ProjectMinViewDTO::new).orElseThrow();
    }

    @Override
    public List<ProjectMinViewDTO> findAllByUserOwner(String userName) {
        return projectRepository.findByOwner(userName).stream().map(ProjectMinViewDTO::new).toList();
    }
}

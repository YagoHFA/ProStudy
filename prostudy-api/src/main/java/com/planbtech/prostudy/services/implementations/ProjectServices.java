package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import com.planbtech.prostudy.entities.model.Project;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.repositories.ProjectRepository;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CategoryReporitory categoryReporitory;

    @Autowired
    private UserRepository userRepository;

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
    public void deleteProject(String username,String projectId) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        Project projectToRemove = user.getUserProjects().stream()
                .filter(project -> project.getProjectId().equals(projectId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Project not found"));

        user.getUserProjects().remove(projectToRemove);
        userRepository.save(user);
        if(projectToRemove.getProjectsUser().isEmpty())
            projectRepository.delete(projectToRemove);
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

package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.ProjectUpdateDTO;
import org.springframework.stereotype.Service;

@Service
public interface IProjectService {
    void updateProject(ProjectUpdateDTO projectUpdateDTO);

    void deleteProject(String projectId);
}

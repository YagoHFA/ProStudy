package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectService {
    void updateProject(ProjectUpdateDTO projectUpdateDTO);

    void deleteProject(String projectId);

    ProjectMinViewDTO findById(String projectId);

    List<ProjectMinViewDTO> findAllByUserOwner(String userName);
}

package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.repositories.ProjectRepository;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

}

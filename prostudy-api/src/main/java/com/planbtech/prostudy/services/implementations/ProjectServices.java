package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;
}

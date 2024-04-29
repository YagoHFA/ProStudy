package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;


}

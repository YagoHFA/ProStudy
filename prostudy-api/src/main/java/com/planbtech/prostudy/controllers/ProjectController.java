package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectUpdateDTO;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProject(@RequestBody ProjectUpdateDTO projectUpdateDTO){
        try {
            projectService.updateProject(projectUpdateDTO);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteProject(@RequestParam String projectId){
        try {
            projectService.deleteProject(projectId);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(true);
    }
}

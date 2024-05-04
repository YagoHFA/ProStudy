package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;
    @Autowired
    private CategoryReporitory categoryReporitory;

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProject(@RequestBody ProjectUpdateDTO projectUpdateDTO){
        try {
            projectService.updateProject(projectUpdateDTO);
            return ResponseEntity.ok(true);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteProject(@RequestParam String projectId){
        try {
            projectService.deleteProject(projectId);
            return ResponseEntity.ok(true);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/project/{projectId}")
    public ResponseEntity<ProjectMinViewDTO> findProject(@PathVariable String projectId){
        try{
            return ResponseEntity.ok(projectService.findById(projectId));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/finda/user/{userName}")
    public ResponseEntity<List<ProjectMinViewDTO>> findUserProject(@PathVariable String userName){
        try
        {
            return ResponseEntity.ok(projectService.findAllByUserOwner(userName));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

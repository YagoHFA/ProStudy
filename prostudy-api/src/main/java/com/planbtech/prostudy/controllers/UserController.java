package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    @PutMapping("/project/add")
    public ResponseEntity<Boolean> addProject(@RequestBody ProjectAddDTO projectDTO){
        try {
            iUserServices.addProject(projectDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/test/complete")
    public ResponseEntity<String> compleTest(@RequestBody TestCompleteDTO testCompleteDTO){
        try {
            iUserServices.completeTest(testCompleteDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

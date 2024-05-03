package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    @PostMapping("conclusion/{userid}/{testid}")
    public ResponseEntity<Boolean> testConclusion(@PathVariable Long userid, @PathVariable String testid){
        iUserServices.testConclusion(userid, testid);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/project/add")
    public ResponseEntity<Boolean> addProject(@RequestBody ProjectAddDTO projectDTO){
        try {
            iUserServices.addProject(projectDTO);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/test/complete")
    public ResponseEntity<String> compleTest(@RequestBody TestCompleteDTO testCompleteDTO){
        try {
            iUserServices.completeTest(testCompleteDTO);

        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}

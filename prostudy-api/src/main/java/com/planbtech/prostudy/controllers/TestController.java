package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import com.planbtech.prostudy.services.interfaces.ITesteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITesteServices testeServices;

    @GetMapping("/find/all")
    public ResponseEntity<List<SkillTestMinDTO>> findAll(){
        return ResponseEntity.ok(testeServices.findAll());
    }

    @GetMapping("/find/{projectid}")
    public ResponseEntity<SkillTestDTO> findExam(@PathVariable String projectId){
        return ResponseEntity.ok(testeServices.findExam(projectId));
    }
}

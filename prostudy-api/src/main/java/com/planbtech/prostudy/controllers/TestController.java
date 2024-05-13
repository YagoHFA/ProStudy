package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import com.planbtech.prostudy.services.interfaces.ITesteServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Gerenciamento de Testes", description = "Gerencia ações realizadas com testes")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITesteServices testeServices;

    @Operation(summary = "Retorna uma lista de todos os testes", description = "Retorna um lista com todos os testes com o mínimo de visualização possível")
    @GetMapping("/find/all")
    public ResponseEntity<List<SkillTestMinDTO>> findAll(){
        return ResponseEntity.ok(testeServices.findAll());
    }

    @Operation(summary = "Busca o teste a ser realizado", description = "Busca as questões e respostas do teste a ser realizado")
    @GetMapping("/find/{testId}")
    public ResponseEntity<SkillTestDTO> findExam(@PathVariable String testId){
        return ResponseEntity.ok(testeServices.findExam(testId));
    }
}

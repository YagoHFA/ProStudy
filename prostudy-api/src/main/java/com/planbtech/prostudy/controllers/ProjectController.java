package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectUpdateDTO;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.IProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gerenciamento de projeto", description = "Gerencia as ações realizadas com projeto")
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;
    @Autowired
    private CategoryReporitory categoryReporitory;

    @Operation(summary = "Atualiza um Projeto", description = "Atualiza um projeto com as informações que vieram no body da requisição")
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

    @Operation(summary = "Deleta um projeto",description = "Deleta um projeto com base no id recebido na requisição")
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

    @Operation(summary = "Retorna as informações minímas do projeto", description = "Retorna as informações necessárias sobre um projeto")
    @GetMapping("/find/project/{projectId}")
    public ResponseEntity<ProjectMinViewDTO> findProject(@PathVariable String projectId){
        try{
            return ResponseEntity.ok(projectService.findById(projectId));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Retorna um lista de projetos", description = "Retorna um lista de projetos com informações minímas ao buscar projetos vinculados ao usuário")
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

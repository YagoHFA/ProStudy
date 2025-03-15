package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectToSendDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserLoadDTO;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gerencia ações de usuário", description = "Gerencia as ações que um usuário pode realizar")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    @Operation(summary = "Adiciona um projeto novo", description = "Adiciona um projeto novo ao mesmo tempo que o vincula ao usuário que o criou como 'Owner'")
    @PutMapping("/project/add")
    public ResponseEntity<Boolean> addProject(@RequestBody ProjectAddDTO projectDTO){
        try {
            iUserServices.addProject(projectDTO);
            return ResponseEntity.ok().build();
        }
        catch (UsernameNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Vincula usuário com teste", description = "Vincula um usuário ao um teste que foi realizado com sucesso")
    @PutMapping("/test/complete")
    public ResponseEntity<HttpStatus> compleTest(@RequestBody TestCompleteDTO testCompleteDTO){
        try {
            iUserServices.completeTest(testCompleteDTO);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/load/{userName}")
    @Operation(summary = "Carrega as informações do usário", description = "Carrega todas as informações do usuario atualmente logado no sistema")
    public ResponseEntity<UserLoadDTO> carregaUser(@PathVariable String userName){
        try {
            return ResponseEntity.ok(iUserServices.loadUser(userName));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/send")
    public ResponseEntity<HttpStatus> sendProject(@RequestBody ProjectToSendDTO projectToSendDTO){
        try {
            iUserServices.sendProject(projectToSendDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}

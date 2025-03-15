package com.planbtech.prostudy.component.security.controller;

import com.planbtech.prostudy.component.security.DTO.UserLoginDTO;
import com.planbtech.prostudy.component.security.DTO.UserLoginResponseDTO;
import com.planbtech.prostudy.component.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.component.security.service.TokenService;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.services.implementations.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gerenciamento de autenticação", description = "Gerencia as autenticações de usuários")
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServices userServices;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Faz a autenticação do usuário", description = "Faz a autenticação do usuário retornando um token de validação para requisições seguintes")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO userToLogIn){
        try {
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(userToLogIn.userName(), userToLogIn.password());

            Authentication auth = this.authenticationManager.authenticate(usernamePassword);

            String token = tokenService.generateToken(((User) auth.getPrincipal()));
            return ResponseEntity.ok(new UserLoginResponseDTO(token));
        }
        catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Cria um usuário", description = "Cria um usuário com permissões de usuário no banco de dados")
    @PostMapping("/register/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserRegisterDTO userToRegister){
        if(this.userServices.findByUserName(userToRegister.userName()).isPresent()) return ResponseEntity.status(401).build();
        this.userServices.createUser(userToRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Cria um usuário 'company'", description = "Cria um usuário com permissões de company no banco de dados")
    @PostMapping("/register/company")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserLoginResponseDTO> registerCompany(@RequestBody UserRegisterDTO userToRegister){
        if(this.userServices.findByUserName(userToRegister.userName()).isPresent()) return ResponseEntity.badRequest().build();
        this.userServices.createCompany(userToRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

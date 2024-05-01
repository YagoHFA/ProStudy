package com.planbtech.prostudy.config.security.controller;

import com.planbtech.prostudy.config.security.DTO.UserLoginDTO;
import com.planbtech.prostudy.config.security.DTO.UserLoginResponseDTO;
import com.planbtech.prostudy.config.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.config.security.service.TokenService;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.implementations.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO userToLogIn){
        System.out.println(userToLogIn.userName());
        System.out.println(userToLogIn.password());
        var usernamePassword = new UsernamePasswordAuthenticationToken(userToLogIn.userName(), userToLogIn.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken(((User) auth.getPrincipal()));
        return ResponseEntity.ok( new UserLoginResponseDTO(token));
    }

    @PostMapping("/register/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserLoginResponseDTO> registerUser(@RequestBody UserRegisterDTO userToRegister){
        if(this.userServices.findByUserName(userToRegister.userName()).isPresent()) return ResponseEntity.badRequest().build();
        this.userServices.createUser(userToRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/register/company")
    public ResponseEntity<HttpStatus> registerCompany(@RequestBody UserRegisterDTO userToRegister){
        if(this.userServices.findByUserName(userToRegister.userName()).isPresent()) return ResponseEntity.badRequest().build();
        this.userServices.createCompany(userToRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

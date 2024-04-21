package com.planbtech.prostudy.config.security;

import com.planbtech.prostudy.DTO.UserLoginDTO;
import com.planbtech.prostudy.DTO.UserRegisterDTO;
import com.planbtech.prostudy.entities.model.Role;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.implementations.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserLoginDTO userToLogIn){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userToLogIn.userName(), userToLogIn.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register/user")
    public ResponseEntity<Boolean> register(@RequestBody UserRegisterDTO userToRegister){
        if(this.userRepository.findByUserName(userToRegister.userName()).isPresent()) return ResponseEntity.badRequest().build();

        String encodedPassword = new BCryptPasswordEncoder().encode(userToRegister.password());
        User user = new User(userToRegister.userName(), encodedPassword);
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}

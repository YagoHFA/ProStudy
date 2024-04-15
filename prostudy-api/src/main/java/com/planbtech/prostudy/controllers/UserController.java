package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    public void createUser(User userToCreate) {
         this.iUserServices.createUser(userToCreate);
    }

    @GetMapping("/login/{email}&{password}")
    public ResponseEntity<UserDTO> login(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(new UserDTO(this.iUserServices.login(email, password)));
    }
}

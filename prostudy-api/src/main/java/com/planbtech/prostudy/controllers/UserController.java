package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    public void createUser(UserDTO userToCreate) {
         this.iUserServices.createUser(userToCreate);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDTO user){
       iUserServices.createUser(user);
    }

}

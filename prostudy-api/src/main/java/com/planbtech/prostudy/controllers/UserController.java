package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    public void createUser(User userToCreate) {
         this.iUserServices.createUser(userToCreate);
    }

    public User login(String email, String password) {
        return this.iUserServices.login(email, password);
    }
}

package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.services.interfaces.ITesteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITesteServices testeServices;
}

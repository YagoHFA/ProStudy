package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.CategoryDTO;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private ICategoryServices categoryServices;

    @GetMapping("/allcategory")
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        return ResponseEntity.ok(categoryServices.findAll());
    }
}

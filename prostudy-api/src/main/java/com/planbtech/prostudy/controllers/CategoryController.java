package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
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

    @GetMapping("/video/allcategory")
    public ResponseEntity<List<CategoryVideoDTO>> listCategoryVideos() {
        return ResponseEntity.ok(categoryServices.findAllVideo());
    }

    @GetMapping("/test/allcategory")
    public ResponseEntity<List<CategoryTestDTO>> listCategoryTests(){
        return ResponseEntity.ok(categoryServices.findAllTest());
    }
    @GetMapping("tools/alltools")
    public ResponseEntity<List<CategoryMinDTO>> toolsList(){
        try
        {
            return ResponseEntity.ok(categoryServices.findAllCategoryName());
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Controle de Categoria", description = "Controla as requisições de categoria")
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private ICategoryServices categoryServices;

    @Operation(summary = "Retorna uma lista de categoria de todas as categorias", description = "Retorna um lista de categorias que contém uma lista de videos vinculada a categoria")
    @GetMapping("/video/allcategory")
    public ResponseEntity<List<CategoryVideoDTO>> listCategoryVideos() {
        return ResponseEntity.ok(categoryServices.findAllVideo());
    }

    @Operation(summary = "Retorna uma lista de categoria de todas as categorias", description = "Retorna um lista de categorias que contém uma lista de testes vinculada a categoria")
    @GetMapping("/test/allcategory")
    public ResponseEntity<List<CategoryTestDTO>> listCategoryTests(){
        return ResponseEntity.ok(categoryServices.findAllTest());
    }

    @Operation(summary = "Retorna uma lista de categoria de todas as categorias", description = "Retorna um lista de categorias que contém uma lista de tools vinculada a categoria")
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

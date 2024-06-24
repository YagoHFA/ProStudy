package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Tag(name = "Gerencia os serviços de Categoria", description = "Aplica as regras de negócios que Categoria deve seguir")
public class CategoryServices implements ICategoryServices {

    @Autowired
    private CategoryReporitory categoryRepository;

    @Transactional
    @Override
    @Operation(summary = "Busca uma Lista de categorias", description = "Busca uma lista de categoria com seus respectivos videos")
    public List<CategoryVideoDTO> findAllVideo() {
        return categoryRepository.findAll().stream().map(CategoryVideoDTO::new).toList();
    }

    @Transactional
    @Override
    public CategoryVideoDTO findCategory(String s) {
        return new CategoryVideoDTO(categoryRepository.findCategory(s));
    }

    @Transactional
    @Override
    public List<CategoryTestDTO> findAllTest() {
        return categoryRepository.findAllCategoryWithTest().stream().map(CategoryTestDTO::new).toList();
    }

    @Transactional
    @Override
    public List<CategoryMinDTO> findAllCategoryName() {
        return categoryRepository.findAllCategorName().stream().map(CategoryMinDTO::new).toList();
    }

    @Override
    public void createCategory(CategoryMinDTO categoryMinDTO) {
        if (categoryRepository.findByCategoryName(categoryMinDTO.getName()).isPresent())
            throw new RuntimeException("Category already exists");
        Category category = Category.builder()
                .categoryName(categoryMinDTO.getName()).build();
        categoryRepository.save(category);
    }


}

package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryCreateError;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryDeleteException;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.CategoryNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.CategoryException.LoadCategoryException;
import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import io.swagger.v3.oas.annotations.Operation;
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
        return new CategoryVideoDTO(categoryRepository.findCategory(s).orElseThrow(()-> new CategoryNotFound("Category not found")));
    }

    @Transactional
    @Override
    public List<CategoryTestDTO> findAllTest() {
        return categoryRepository.findAllCategoryWithTest().orElseThrow(()-> new LoadCategoryException("Error on load category with tests")).stream().map(CategoryTestDTO::new).toList();
    }

    @Transactional
    @Override
    public List<CategoryMinDTO> findAllCategoryName() {
        return categoryRepository.findAllCategoryName().stream().map(CategoryMinDTO::new).toList();
    }

    @Transactional
    @Override
    public void createCategory(CategoryMinDTO categoryMinDTO) {
        if (categoryRepository.findByCategoryName(categoryMinDTO.getName()).isPresent())
            throw new CategoryCreateError("Category already exists");
        Category category = Category.builder()
                .categoryName(categoryMinDTO.getName()).build();
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void deleteCategory(CategoryMinDTO categoryMinDTO) {
        categoryRepository.delete(categoryRepository.findByCategoryName(categoryMinDTO.getName()).orElseThrow(() -> new CategoryDeleteException("Error on delete category")));
    }


}

package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.CategoryDTO;
import com.planbtech.prostudy.entities.model.Category;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServices implements ICategoryServices {

    @Autowired
    private CategoryReporitory categoryRepository;

    @Transactional
    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categoryList = categoryRepository.findAll().stream().toList();
        categoryList.forEach(System.out::println);
        return categoryRepository.findAll().stream().map(CategoryDTO::new).toList();
    }

    @Override
    public CategoryDTO findCategory(String s) {
        return new CategoryDTO(categoryRepository.findCategory(s));
    }
}

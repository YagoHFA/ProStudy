package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices implements ICategoryServices {

    @Autowired
    private CategoryReporitory categoryRepository;

    @Transactional
    @Override
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
}

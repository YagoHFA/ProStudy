package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.CategoryDTO;
import com.planbtech.prostudy.repositories.CategoryReporitory;
import com.planbtech.prostudy.services.interfaces.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices implements ICategoryServices {

    @Autowired
    private CategoryReporitory categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {

        return categoryRepository.findAll().stream().map(CategoryDTO::new).toList();
    }

    @Override
    public CategoryDTO findCategory(String s) {
        return new CategoryDTO(categoryRepository.findCategory(s));
    }
}

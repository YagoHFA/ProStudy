package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.CategoryDTO;
import com.planbtech.prostudy.entities.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryServices {
    List<CategoryDTO> findAll();

}

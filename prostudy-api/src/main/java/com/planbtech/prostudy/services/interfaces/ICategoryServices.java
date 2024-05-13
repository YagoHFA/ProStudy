package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.CategoryDTO.CategoryMinDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryDTO.CategoryVideoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryServices {
    List<CategoryVideoDTO> findAllVideo();

    CategoryVideoDTO findCategory(String s);

    List<CategoryTestDTO> findAllTest();

    List<CategoryMinDTO> findAllCategoryName();
}

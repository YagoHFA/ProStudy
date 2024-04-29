package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.CategoryTestDTO;
import com.planbtech.prostudy.DTO.CategoryVideoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryServices {
    List<CategoryVideoDTO> findAllVideo();

    CategoryVideoDTO findCategory(String s);

    List<CategoryTestDTO> findAllTest();
}

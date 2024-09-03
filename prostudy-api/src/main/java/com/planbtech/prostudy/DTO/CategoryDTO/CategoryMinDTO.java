package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.entities.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMinDTO {


    private String name;

    public CategoryMinDTO(Category entity) {
        this.name = entity.getCategoryName();
    }
}

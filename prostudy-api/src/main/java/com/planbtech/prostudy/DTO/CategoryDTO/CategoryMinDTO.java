package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.entities.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "As informações minímas de categoria")
public class CategoryMinDTO {

    @Schema(description = "O nome da categoria")
    private String name;

    public CategoryMinDTO(Category entity) {
        this.name = entity.getCategoryName();
    }
}

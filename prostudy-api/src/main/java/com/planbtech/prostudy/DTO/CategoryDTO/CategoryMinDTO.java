package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.entities.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Minimum info needed of Category", name = "Min Category info")
public class CategoryMinDTO {

    @Schema(description = "Name of Category")
    private String name;

    public CategoryMinDTO(Category entity) {
        this.name = entity.getCategoryName();
    }
}

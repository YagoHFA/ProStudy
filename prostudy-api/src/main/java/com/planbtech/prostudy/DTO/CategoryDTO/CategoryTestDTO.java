package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import com.planbtech.prostudy.entities.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "All categories that are associated with tests.")
public class CategoryTestDTO {

    @Schema(description = "The name of Category that have tests")
    private String categoryName;
    @Schema(description = "List of tests in Category")
    private List<SkillTestMinDTO> skillTestList;

    public CategoryTestDTO(Category entity){
        this.categoryName = entity.getCategoryName();
        this.skillTestList = entity.getSkillTestList().stream().map(SkillTestMinDTO::new).toList();
    }
}

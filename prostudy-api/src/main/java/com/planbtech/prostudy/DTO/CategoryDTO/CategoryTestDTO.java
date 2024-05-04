package com.planbtech.prostudy.DTO.CategoryDTO;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import com.planbtech.prostudy.entities.model.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTestDTO {

    private String categoryName;
    private List<SkillTestMinDTO> skillTestList;

    public CategoryTestDTO(Category entity){
        this.categoryName = entity.getCategoryName();
        this.skillTestList = entity.getSkillTestList().stream().map(SkillTestMinDTO::new).toList();
    }
}

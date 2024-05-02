package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.Category;
import lombok.*;

import javax.swing.text.html.parser.Entity;

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

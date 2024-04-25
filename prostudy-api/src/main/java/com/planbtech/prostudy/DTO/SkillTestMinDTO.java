package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillTestMinDTO {
    private String title;
    private String shortDescription;
    private String testId;

    public SkillTestMinDTO(SkillTest entity){
        this.shortDescription = entity.getTestShortDescription();
        this.title = entity.getTestTitle();
        this.testId = entity.getTestId();
    }
}

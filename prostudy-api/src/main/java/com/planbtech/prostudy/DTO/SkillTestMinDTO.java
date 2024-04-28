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
    private String longDescription;
    private String testId;
    private int   questionNumber;

    public SkillTestMinDTO(SkillTest entity){
        this.shortDescription = entity.getTestShortDescription();
        this.longDescription = entity.getTestLongDescription();
        this.title = entity.getTestTitle();
        this.testId = entity.getTestId();
        this.questionNumber = entity.getQuestions().size();
    }
}

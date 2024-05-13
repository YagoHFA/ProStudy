package com.planbtech.prostudy.DTO.SkillTestDTO;

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
    private String badgeURL;

    public SkillTestMinDTO(SkillTest entity){
        this.shortDescription = entity.getTestShortDescription();
        this.longDescription = entity.getTestLongDescription();
        this.title = entity.getTestTitle();
        this.testId = entity.getTestId();
        this.questionNumber = entity.getQuestions().size();
        this.badgeURL = entity.getBadgeURL();
    }
}

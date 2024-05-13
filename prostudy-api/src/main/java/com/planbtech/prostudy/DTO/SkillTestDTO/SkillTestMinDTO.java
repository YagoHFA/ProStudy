package com.planbtech.prostudy.DTO.SkillTestDTO;

import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillTestMinDTO {

    private String testTitle;
    private String testShortDescription;
    private String testLongDescription;
    private String testId;
    private int   questionNumber;
    private String badgeURL;

    public SkillTestMinDTO(SkillTest entity){
        this.testShortDescription = entity.getTestShortDescription();
        this.testLongDescription = entity.getTestLongDescription();
        this.testTitle = entity.getTestTitle();
        this.testId = entity.getTestId();
        this.questionNumber = entity.getQuestions().size();
        this.badgeURL = entity.getBadgeURL();
    }
}

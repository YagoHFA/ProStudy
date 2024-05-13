package com.planbtech.prostudy.DTO.SkillTestDTO;

import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillTestUserShowDTO {

    private String testTitle;
    private String badgeURL;

    public SkillTestUserShowDTO(SkillTest entity){
        this.testTitle = entity.getTestTitle();
        this.badgeURL = entity.getBadgeURL();
    }
}

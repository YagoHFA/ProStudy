package com.planbtech.prostudy.DTO.SkillTestDTO;

import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillTestUserShowDTO {

    private String title;
    private String badgeURL;

    public SkillTestUserShowDTO(SkillTest entity){
        this.title = entity.getTestTitle();
        this.badgeURL = entity.getBadgeURL();
    }
}

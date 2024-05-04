package com.planbtech.prostudy.DTO.SkillTestDTO;

import com.planbtech.prostudy.DTO.QuestionDTO.QuestionDTO;
import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillTestDTO {

    private List<QuestionDTO> questionsList;
    private String testTitle;

    public SkillTestDTO(SkillTest entity){
        this.questionsList = entity.getQuestions().stream().map(QuestionDTO::new).toList();
        this.testTitle = entity.getTestTitle();
    }
}

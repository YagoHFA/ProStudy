package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.Answer;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswersDTO {

    private String answers;
    private BigDecimal points;

    public AnswersDTO(Answer entity){
        this.answers = entity.getAnswers();
        this.points = entity.getPoints();
    }
}

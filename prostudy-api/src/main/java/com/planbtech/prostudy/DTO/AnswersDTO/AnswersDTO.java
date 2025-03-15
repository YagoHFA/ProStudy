package com.planbtech.prostudy.DTO.AnswersDTO;

import com.planbtech.prostudy.entities.model.Answer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Model of answer that appears in question selection", name = "Question option model")
public class AnswersDTO {

    @Schema(description = "Answer text")
    private String answers;

    @Schema(description = "Answer points")
    private BigDecimal points;

    public AnswersDTO(Answer entity){
        this.answers = entity.getAnswers();
        this.points = entity.getPoints();
    }
}

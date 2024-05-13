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
@Schema(description = "Modelo de reposta a ser enviada na lista que perguntas contém")
public class AnswersDTO {

    @Schema(description = "O texto da reposta")
    private String answers;

    @Schema(description = "A quantidade de pontos que a reposta vale")
    private BigDecimal points;

    public AnswersDTO(Answer entity){
        this.answers = entity.getAnswers();
        this.points = entity.getPoints();
    }
}

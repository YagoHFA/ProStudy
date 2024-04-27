package com.planbtech.prostudy.DTO;

import com.planbtech.prostudy.entities.model.Question;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    private String questionText;
    private String questionImage;
    private List<AnswersDTO> anwersList;

    public QuestionDTO(Question entity){
        this.anwersList = entity.getAnswerList().stream().map(AnswersDTO::new).toList();
        this.questionImage = entity.getQuesyionImage();
        this.questionText = entity.getQuestionText();
    }
}

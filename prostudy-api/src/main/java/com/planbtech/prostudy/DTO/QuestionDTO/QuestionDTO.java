package com.planbtech.prostudy.DTO.QuestionDTO;

import com.planbtech.prostudy.DTO.AnswersDTO.AnswersDTO;
import com.planbtech.prostudy.entities.model.Question;
import lombok.*;

import java.util.Collections;
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

    public void shuffleAnswers() {
        Collections.shuffle(this.anwersList);
    }
}

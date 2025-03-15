package com.planbtech.prostudy.DTO.SkillTestDTO;

import com.planbtech.prostudy.DTO.QuestionDTO.QuestionDTO;
import com.planbtech.prostudy.entities.model.SkillTest;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillTestDTO {

    private String testId;
    private List<QuestionDTO> questionsList;
    private String testTitle;
    private String badgeURL;

    public SkillTestDTO(SkillTest entity){
        this.questionsList = entity.getQuestions().stream().map(QuestionDTO::new).toList();
        this.testTitle = entity.getTestTitle();
        this.badgeURL = entity.getBadgeURL();
        this.testId = entity.getTestId();
    }

    public void shuffleQuestions() {
        Collections.shuffle(this.questionsList);
        this.questionsList.forEach(QuestionDTO::shuffleAnswers);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillTestDTO)) return false;

        SkillTestDTO that = (SkillTestDTO) o;
        return Objects.equals(getTestId(), that.getTestId()) && Objects.equals(getQuestionsList(), that.getQuestionsList()) && Objects.equals(getTestTitle(), that.getTestTitle()) && Objects.equals(getBadgeURL(), that.getBadgeURL());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getTestId());
        result = 31 * result + Objects.hashCode(getQuestionsList());
        result = 31 * result + Objects.hashCode(getTestTitle());
        result = 31 * result + Objects.hashCode(getBadgeURL());
        return result;
    }
}

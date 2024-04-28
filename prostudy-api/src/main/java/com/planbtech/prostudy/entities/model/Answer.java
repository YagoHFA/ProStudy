package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerid")
    private Long AnswersId;

    @Column(name = "answertext")
    private String answers;

    @Column(name = "answerpoints")
    private BigDecimal points;

    @ManyToOne
    @JoinColumn(name = "questionid")
    private Question question;

}

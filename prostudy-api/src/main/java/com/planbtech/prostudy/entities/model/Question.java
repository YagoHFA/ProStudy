package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionid")
    private Long question;

    @Column(name = "questiontext", columnDefinition = "TinyText")
    private String questionText;

    @Column(name = "questionimage", columnDefinition = "TinyText")
    private String quesyionImage;

    @ManyToOne
    @JoinColumn(name = "testid", nullable = false)
    private SkillTest testId;
}

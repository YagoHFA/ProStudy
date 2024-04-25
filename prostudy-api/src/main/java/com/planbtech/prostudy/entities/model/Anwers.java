package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anwers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AnwersId;

    private String anwers;

    private float points;

    @ManyToOne
    @JoinColumn(name = "questionid")
    private Question question;

}

package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "tests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillTest {

    @Id
    @Column(name = "testid")
    private String testId;

    @Column(name = "testtitle")
    private String testTitle;

    @Column(name = "testdescriptionlong", columnDefinition = "tinytext")
    private String testLongDescription;

    @Column(name = "testdescriptionshort" , length = 100)
    private String testShortDescription;

    @OneToMany(mappedBy = "testId", cascade = CascadeType.ALL)
    private List<Question> questions;

    @ManyToMany(mappedBy = "skillTests")
    private List<User> users;

    public SkillTest(String testId, String testTitle, String testLongDescription, String testShortDescription) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.testLongDescription = testLongDescription;
        this.testShortDescription = testShortDescription;
    }

}

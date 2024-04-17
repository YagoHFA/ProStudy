package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tests")
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

    public SkillTest() {
    }


    public SkillTest(String testId, String testTitle, String testLongDescription, String testShortDescription) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.testLongDescription = testLongDescription;
        this.testShortDescription = testShortDescription;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestLongDescription() {
        return testLongDescription;
    }

    public void setTestLongDescription(String testLongDescription) {
        this.testLongDescription = testLongDescription;
    }

    public String getTestShortDescription() {
        return testShortDescription;
    }

    public void setTestShortDescription(String testShortDescription) {
        this.testShortDescription = testShortDescription;
    }
}

package com.planbtech.prostudy.entities.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User_ProjectId {

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "projectid")
    private Project projectId;
}

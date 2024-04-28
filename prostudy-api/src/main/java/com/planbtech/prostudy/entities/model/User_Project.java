package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User_Project {

    @EmbeddedId
    private User_ProjectId id;

    private String permission;
}


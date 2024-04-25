package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "roleid")
    private String roleId;

    @Column(name = "rolename")
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}

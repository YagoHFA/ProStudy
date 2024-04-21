package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "roleid")
    private String roleId;

    @Column(name = "rolename")
    private String roleName;


    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }
}

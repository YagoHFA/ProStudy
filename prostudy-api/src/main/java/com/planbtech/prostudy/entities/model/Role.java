package com.planbtech.prostudy.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @ManyToMany(mappedBy = "userRole")
    private List<User> users;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}

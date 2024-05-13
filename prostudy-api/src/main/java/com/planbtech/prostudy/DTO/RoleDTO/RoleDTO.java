package com.planbtech.prostudy.DTO.RoleDTO;

import com.planbtech.prostudy.entities.model.Role;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private String id;
    private String roleName;

    public RoleDTO(Role entity) {
        this.roleName = entity.getRoleName();
        this.id = entity.getRoleId();
    }
}

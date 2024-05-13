package com.planbtech.prostudy.DTO.UserDTO;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.DTO.RoleDTO.RoleDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestUserShowDTO;
import com.planbtech.prostudy.entities.model.Role;
import com.planbtech.prostudy.entities.model.User;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoadDTO {

        private String email;
        private List<RoleDTO> roles;
        private List<SkillTestUserShowDTO> skillTests;
        private List<ProjectMinViewDTO> projects;

        public UserLoadDTO(User entity){
                this.email = entity.getUserEmail();
                this.roles = entity.getUserRole().stream().map(RoleDTO::new).toList();
                this.skillTests = entity.getSkillTests().stream().map(SkillTestUserShowDTO::new).toList();
                this.projects = entity.getProjects().stream().map(ProjectMinViewDTO::new).toList();
        }
}

